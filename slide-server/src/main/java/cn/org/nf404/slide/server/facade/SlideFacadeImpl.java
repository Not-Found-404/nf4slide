package cn.org.nf404.slide.server.facade;

import cn.org.nf404.slide.api.facade.SlideFacade;
import cn.org.nf404.slide.api.request.slide.SlideCreateRequest;
import cn.org.nf404.slide.api.request.slide.SlideRenderDetailRequest;
import cn.org.nf404.slide.api.request.slide.SlideUpdateRequest;
import cn.org.nf404.slide.api.response.slide.SlideInfo;
import cn.org.nf404.slide.common.model.request.Response;
import cn.org.nf404.slide.server.domain.service.SlideReadService;
import cn.org.nf404.slide.server.domain.service.SlideWriteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static cn.org.nf404.slide.common.utils.FacadeExecutor.execute;

/**
 * @author dx DingXing
 * @since 2020-10-14
 */
@Slf4j
@Service
@AllArgsConstructor
public class SlideFacadeImpl implements SlideFacade {
    private final SlideWriteService slideWriteService;
    private final SlideReadService slideReadService;

    @Override
    public Response<SlideInfo> create(SlideCreateRequest request) {
        return execute(request, this.slideWriteService::create);
    }

    @Override
    public Response<SlideInfo> update(SlideUpdateRequest request) {
        return execute(request, this.slideWriteService::update);
    }

    @Override
    public Response<SlideInfo> renderDetail(SlideRenderDetailRequest request) {
        return execute(request, this.slideReadService::renderDetail);
    }
}
