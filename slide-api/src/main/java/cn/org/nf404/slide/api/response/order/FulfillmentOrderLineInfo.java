package cn.org.nf404.slide.api.response.order;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @date 2020-10-02
 */
@Data
public class FulfillmentOrderLineInfo implements Serializable {

    private static final long serialVersionUID = 4600868286311734513L;

    private Long id;

    private Long fulfillmentOrderId;

    private Long dealerId;

    private Long goodsId;

    private Long quantity;

    private OperateDescInfo operateDesc;

    private GoodsInfo goods;

    private PriceInfo price;
}
