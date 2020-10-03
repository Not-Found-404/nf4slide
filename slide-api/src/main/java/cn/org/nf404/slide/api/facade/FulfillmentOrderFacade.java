package cn.org.nf404.slide.api.facade;

import cn.org.nf404.slide.api.request.dealer.FulfillmentOrderPagingRequest;
import cn.org.nf404.slide.api.request.fulfillment.FulfillmentOrderCreateRequest;
import cn.org.nf404.slide.api.request.fulfillment.FulfillmentOrderDetailRequest;
import cn.org.nf404.slide.api.response.order.FulfillmentOrderInfo;
import cn.org.nf404.slide.common.model.request.Paging;
import cn.org.nf404.slide.common.model.request.Response;

/**
 * @author dx DingXing
 * @date 2020-09-30
 */
public interface FulfillmentOrderFacade {
    Response<Long> create(FulfillmentOrderCreateRequest t);

    Response<Paging<FulfillmentOrderInfo>> paging(FulfillmentOrderPagingRequest t);

    Response<FulfillmentOrderInfo> renderDetail(FulfillmentOrderDetailRequest t);
}
