package cn.org.nf404.slide.server.facade;

import cn.org.nf404.slide.api.facade.FulfillmentOrderFacade;
import cn.org.nf404.slide.api.request.fulfillment.FulfillmentOrderCreateRequest;
import cn.org.nf404.slide.common.model.request.Response;
import cn.org.nf404.slide.common.utils.FacadeExecutor;
import cn.org.nf404.slide.server.domain.service.FulfillmentOrderWriteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author dx DingXing
 * @date 2020-09-30
 */
@Slf4j
@Service
@AllArgsConstructor
public class FulfillmentOrderFacadeImpl implements FulfillmentOrderFacade {
    private final FulfillmentOrderWriteService orderWriteService;

    @Override
    public Response<Long> create(FulfillmentOrderCreateRequest request) {
        return FacadeExecutor.execute(request, this.orderWriteService::create);
    }
}
