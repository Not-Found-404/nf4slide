package cn.org.nf404.slide.server.domain.converter;

import cn.org.nf404.slide.api.request.slide.SlideRenderQueryRequest;
import cn.org.nf404.slide.api.response.slide.SlideContentInfo;
import cn.org.nf404.slide.api.response.slide.SlideInfo;
import cn.org.nf404.slide.server.domain.model.Slide;
import cn.org.nf404.slide.server.domain.model.SlideContent;
import cn.org.nf404.slide.server.repository.criteria.SlideQueryCriteria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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

    /**
     * Request to criteria
     *
     * @param request SlideRenderQueryRequest
     * @return SlideQueryCriteria
     */
    @Mapping(target = "author", source = "userId")
    @Mapping(target = "name", source = "slideName")
    SlideQueryCriteria convert(SlideRenderQueryRequest request);
}
