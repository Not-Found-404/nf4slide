package cn.org.nf404.slide.server.domain.service;

import cn.org.nf404.slide.api.request.slide.SlideRenderDetailRequest;
import cn.org.nf404.slide.api.response.slide.SlideInfo;
import cn.org.nf404.slide.common.utils.AssertUtil;
import cn.org.nf404.slide.server.domain.converter.RequestConverter;
import cn.org.nf404.slide.server.domain.model.Slide;
import cn.org.nf404.slide.server.repository.impl.SlideRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        return this.converter.model2Info(slide);
    }
}
