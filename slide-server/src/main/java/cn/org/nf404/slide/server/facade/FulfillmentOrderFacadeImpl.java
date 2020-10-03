package cn.org.nf404.slide.server.facade;

import cn.org.nf404.slide.api.facade.FulfillmentOrderFacade;
import cn.org.nf404.slide.api.request.dealer.FulfillmentOrderPagingRequest;
import cn.org.nf404.slide.api.request.fulfillment.FulfillmentOrderCreateRequest;
import cn.org.nf404.slide.api.request.fulfillment.FulfillmentOrderDetailRequest;
import cn.org.nf404.slide.api.response.order.FulfillmentOrderInfo;
import cn.org.nf404.slide.common.model.request.Paging;
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

    @Override
    public Response<Paging<FulfillmentOrderInfo>> paging(FulfillmentOrderPagingRequest t) {
        return null;
    }

    @Override
    public Response<FulfillmentOrderInfo> renderDetail(FulfillmentOrderDetailRequest request) {
        return FacadeExecutor.execute(request, this.orderWriteService::renderDetail);
    }
}
