package cn.org.nf404.slide.server.domain.service;

import cn.org.nf404.slide.api.enums.SlideContentTypeEnum;
import cn.org.nf404.slide.api.request.slide.SlideCreateRequest;
import cn.org.nf404.slide.api.request.slide.SlideUpdateRequest;
import cn.org.nf404.slide.api.response.slide.SlideInfo;
import cn.org.nf404.slide.common.utils.AssertUtil;
import cn.org.nf404.slide.server.domain.converter.RequestConverter;
import cn.org.nf404.slide.server.domain.model.Slide;
import cn.org.nf404.slide.server.domain.model.SlideContent;
import cn.org.nf404.slide.server.repository.impl.SlideRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author dx DingXing
 * @since 2020-10-06
 */
@Slf4j
@Service
@AllArgsConstructor
public class SlideWriteService {
    private final SlideRepository slideRepository;
    private final RequestConverter converter;

    public SlideInfo create(SlideCreateRequest request) {
        // TODO: 2020-10-14 Check
        Slide toCreateSlide = Slide.init(request.getSlideName(), request.getCreatorId(), request.getFolderId());

        Slide slide = this.slideRepository.create(toCreateSlide);
        return converter.model2Info(slide);
    }

    public SlideInfo update(SlideUpdateRequest request) {
        Slide slide = this.slideRepository.findById(request.getSlideId());
        AssertUtil.nonExist(slide, "slide", request.getSlideId());
        // TODO: 2020-10-14 Check permissions
        if (null != request.getSlideName()) {
            slide.setName(request.getSlideName());
            slide.getAuthors().add(request.getUpdateBy().toString());
        }
        if (request.updateContent()) {

            SlideContent content = slide.getContent();
            if (null != request.getSlideContent()) {
                content.setContentType((Enum.valueOf(SlideContentTypeEnum.class, request.getContentType())));
                content.setContentText(request.getSlideContent());
            }
            if (null != request.getConfig()) {
                content.getConfig().putAll(request.getConfig());
            }
        } else {
            // It does not need to update the content
            slide.setContent(null);
        }

        return this.converter.model2Info(this.slideRepository.update(slide));
    }
}
