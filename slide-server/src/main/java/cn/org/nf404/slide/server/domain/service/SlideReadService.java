package cn.org.nf404.slide.server.domain.service;

import cn.org.nf404.slide.api.request.slide.SlideRenderDetailRequest;
import cn.org.nf404.slide.api.request.slide.SlideRenderQueryRequest;
import cn.org.nf404.slide.api.response.slide.SlideInfo;
import cn.org.nf404.slide.common.utils.AssertUtil;
import cn.org.nf404.slide.server.domain.converter.RequestConverter;
import cn.org.nf404.slide.server.domain.model.Slide;
import cn.org.nf404.slide.server.repository.criteria.SlideQueryCriteria;
import cn.org.nf404.slide.server.repository.impl.SlideRepository;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dx DingXing
 * @since 2020-10-14
 */
@Slf4j
@Service
@AllArgsConstructor
public class SlideReadService {
    private final SlideRepository slideRepository;
    private final RequestConverter converter;

    public SlideInfo renderDetail(SlideRenderDetailRequest request) {
        Long slideId = request.getSlideId();
        Slide slide = this.slideRepository.findById(slideId);
        AssertUtil.nonExist(slide, "slide", slideId);
        return this.converter.convert(slide);
    }

    public List<SlideInfo> query(SlideRenderQueryRequest request) {
        if (Strings.isNullOrEmpty(request.getSlideName())) {
            return Lists.newArrayListWithCapacity(0);
        }

        SlideQueryCriteria criteria = this.converter.convert(request);

        return this.slideRepository.query(criteria).stream()
                .map(this.converter::convert)
                .collect(Collectors.toList());
    }
}
