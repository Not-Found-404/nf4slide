package cn.org.nf404.slide.server.facade;

import cn.org.nf404.slide.api.facade.DealerFacade;
import cn.org.nf404.slide.api.request.dealer.DealerCreateRequest;
import cn.org.nf404.slide.common.model.request.Response;
import cn.org.nf404.slide.common.utils.FacadeExecutor;
import cn.org.nf404.slide.server.domain.service.DealerReadService;
import cn.org.nf404.slide.server.domain.service.DealerWriteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Slf4j
@Service
@AllArgsConstructor
public class DealerFacadeImpl implements DealerFacade {
    private final DealerWriteService dealerWriteService;
    private final DealerReadService dealerReadService;


    @Override
    public Response<Long> create(DealerCreateRequest request) {
        return FacadeExecutor.execute(request, this.dealerWriteService::create);
    }
}
