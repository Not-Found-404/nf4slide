package cn.org.nf404.slide.server.repository.impl;

import cn.org.nf404.slide.api.response.slide.SlideInfo;
import cn.org.nf404.slide.server.domain.model.Slide;
import cn.org.nf404.slide.server.domain.model.SlideContent;
import cn.org.nf404.slide.server.repository.converter.DoConverter;
import cn.org.nf404.slide.server.repository.criteria.SlideQueryCriteria;
import cn.org.nf404.slide.server.repository.dao.SlideContentDao;
import cn.org.nf404.slide.server.repository.dao.SlideDao;
import cn.org.nf404.slide.server.repository.entity.BaseDO;
import cn.org.nf404.slide.server.repository.entity.SlideContentDO;
import cn.org.nf404.slide.server.repository.entity.SlideDO;
import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dx DingXing
 * @since 2020-10-06
 */
@Repository
@AllArgsConstructor
public class SlideRepository {
    private final SlideDao slideDao;
    private final SlideContentDao contentDao;
    private final DoConverter doConverter;

    @Transactional(rollbackFor = Exception.class)
    public Slide create(Slide toSave) {
        if (null == toSave) {
            return null;
        }

        // Persist slide
        SlideDO slideDO = this.doConverter.convert(toSave);
        BaseDO.init(slideDO);
        SlideDO save = this.slideDao.save(slideDO);

        // Persist slide content
        SlideContentDO contentDO = this.doConverter.convert(toSave.getContent());
        if (null != contentDO) {
            BaseDO.init(contentDO);
            this.contentDao.save(contentDO);
        }

        return this.doConverter.convert(save);
    }

    @Cached(name = "nf4-slide-", key = "#slideId", expire = 3600, cacheType = CacheType.REMOTE)
    public Slide findById(Long slideId) {
        if (null == slideId) {
            return null;
        }
        Optional<SlideDO> byId = this.slideDao.findById(slideId);
        Slide slide = this.doConverter.convert(byId.orElse(null));
        if (null == slide) {
            return null;
        }

        Specification<SlideContentDO> specification = Specification.where((Specification<SlideContentDO>) (root, cq, cb) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(cb.equal(root.<Integer>get("slideId"), slideId));
            return cq.where(list.toArray(new Predicate[0])).getRestriction();
        });

        SlideContent last = this.contentDao.findAll(specification, Sort.by("version")).stream()
                .map(this.doConverter::convert)
                .findFirst().orElse(null);
        slide.setContent(last);

        return slide;
    }

    @Transactional(rollbackFor = Exception.class)
    @CacheInvalidate(name = "nf4-slide-", key = "#slide.id")
    public Slide update(Slide slide) {
        SlideDO slideDO = this.doConverter.convert(slide);
        slideDO.setUpdatedAt(new Date());
        this.slideDao.save(slideDO);

        SlideContent content = slide.getContent();
        if (null != content) {
            SlideContentDO contentDO = this.doConverter.convert(content);
            contentDO.setUpdatedAt(new Date());
            this.contentDao.save(contentDO);
        }

        return slide;
    }

    public List<Slide> query(SlideQueryCriteria criteria) {
        if (null == criteria || criteria.isEmpty()) {
            return Collections.emptyList();
        }

        Specification<SlideDO> specification = Specification.where((Specification<SlideDO>) (root, cq, cb) -> {
            List<Predicate> list = new ArrayList<>();
            if (null != criteria.getFolderId()) {
                list.add(cb.equal(root.<Long>get("folderId"), criteria.getFolderId()));
            }
            return cq.where(list.toArray(new Predicate[0])).getRestriction();
        });

        return this.slideDao.findAll(specification).stream()
                .map(this.doConverter::convert)
                .collect(Collectors.toList());
    }
}
