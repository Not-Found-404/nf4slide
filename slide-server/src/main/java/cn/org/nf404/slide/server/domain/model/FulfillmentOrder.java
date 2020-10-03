package cn.org.nf404.slide.server.domain.model;

import cn.org.nf404.slide.common.model.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FulfillmentOrder extends BaseModel implements Serializable {
    private static final long serialVersionUID = -1796514597107389483L;

    private Long dealerId;

    private String paymentVoucher;

    private String remark;

    private Dealer dealer;

    private Price price;

    private OperateDesc operateDesc;

    private OrderStatus orderStatus;

    private List<FulfillmentOrderLine> fulfillmentOrderLines;
}
