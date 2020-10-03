package cn.org.nf404.slide.api.request.fulfillment;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dx DingXing
 * @date 2020-10-02
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FulfillmentOrderDetailRequest extends AbstractRequest {
    private static final long serialVersionUID = 7444989850335577666L;

    private Long fulfillmentOrderId;
}
