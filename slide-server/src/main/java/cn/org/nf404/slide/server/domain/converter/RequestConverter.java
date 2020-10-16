package cn.org.nf404.slide.server.domain.converter;

import cn.org.nf404.slide.api.response.slide.SlideContentInfo;
import cn.org.nf404.slide.api.response.slide.SlideInfo;
import cn.org.nf404.slide.server.domain.model.Slide;
import cn.org.nf404.slide.server.domain.model.SlideContent;
import org.mapstruct.Mapper;

/**
 * @author dx DingXing
 * @since 2020-10-14
 */
@Mapper(componentModel = "spring")
public interface RequestConverter {
    /**
     * Model to info
     *
     * @param slide Slide
     * @return SlideInfo
     */
    SlideInfo convert(Slide slide);

    /**
     * Model to info
     *
     * @param content SlideContent
     * @return SlideContentInfo
     */
    @SuppressWarnings("unused")
    SlideContentInfo convert(SlideContent content);
}
