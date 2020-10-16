package cn.org.nf404.slide.api.facade;

import cn.org.nf404.slide.api.request.slide.SlideCreateRequest;
import cn.org.nf404.slide.api.request.slide.SlideRenderDetailRequest;
import cn.org.nf404.slide.api.request.slide.SlideUpdateRequest;
import cn.org.nf404.slide.api.response.slide.SlideInfo;
import cn.org.nf404.slide.common.model.request.Response;

/**
 * @author dx DingXing
 * @since 2020-10-14
 */
public interface SlideFacade {
    /**
     * Create empty slide without content
     *
     * @param request Slide basic info
     * @return Slide
     */
    Response<SlideInfo> create(SlideCreateRequest request);

    /**
     * Update slide metadata or slide content
     *
     * @param request Slide basic info
     * @return Slide
     */
    Response<SlideInfo> update(SlideUpdateRequest request);

    /**
     * Render slide detail with cache
     *
     * @param request Slide id
     * @return Slide info with content
     */
    Response<SlideInfo> renderDetail(SlideRenderDetailRequest request);
}
