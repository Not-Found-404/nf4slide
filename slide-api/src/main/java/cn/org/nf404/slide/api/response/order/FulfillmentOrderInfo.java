package cn.org.nf404.slide.api.response.order;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author dx DingXing
 * @date 2020-10-02
 */
@Data
public class FulfillmentOrderInfo implements Serializable {
    private static final long serialVersionUID = -5800183934686144538L;

    private Long id;

    private Long dealerId;

    private String paymentVoucher;

    private String remark;

    private DealerInfo dealer;

    private PriceInfo price;

    private OperateDescInfo operateDesc;

    private OrderStatusInfo orderStatus;

    private List<FulfillmentOrderLineInfo> fulfillmentOrderLines;

}
