package cn.org.nf404.slide.server.repository.impl;

import cn.org.nf404.slide.server.domain.model.Goods;
import cn.org.nf404.slide.server.repository.converter.GoodsDoConverter;
import cn.org.nf404.slide.server.repository.dao.GoodsDao;
import cn.org.nf404.slide.server.repository.entity.BaseDO;
import cn.org.nf404.slide.server.repository.entity.GoodsDO;
import cn.org.nf404.slide.server.repository.entity.UserDO;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Repository
@AllArgsConstructor
public class GoodsRepository {
    private final GoodsDoConverter doConverter;
    private final GoodsDao goodsDao;

    public Long save(Goods goods) {
        GoodsDO goodsDO = this.doConverter.model2Do(goods);
        BaseDO.init(goodsDO);
        return this.goodsDao.save(goodsDO).getId();
    }

    public List<Goods> findByIds(Collection<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Lists.newArrayListWithCapacity(0);
        }

        Specification<GoodsDO> specification = Specification.where((Specification<GoodsDO>) (root, cq, cb) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(root.<Long>get("id").in(ids));
            return cq.where(list.toArray(new Predicate[0])).getRestriction();
        });

        return this.goodsDao.findAll(specification).stream()
                .map(this.doConverter::do2Model)
                .collect(Collectors.toList());
    }
}
