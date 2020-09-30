package cn.org.nf404.slide.api.facade;

import cn.org.nf404.slide.api.request.fulfillment.FulfillmentOrderCreateRequest;
import cn.org.nf404.slide.common.model.request.Response;

/**
 * @author dx DingXing
 * @date 2020-09-30
 */
public interface FulfillmentOrderFacade {
     Response<Long> create(FulfillmentOrderCreateRequest t);
}
