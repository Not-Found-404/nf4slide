package cn.org.nf404.slide.server.domain.model;

import cn.org.nf404.slide.common.model.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FulfillmentOrderLine extends BaseModel implements Serializable {
    private static final long serialVersionUID = -5227950689490097121L;

    private Long fulfillmentOrderId;

    private Long dealerId;

    private Long goodsId;

    private Long quantity;

    private OperateInfo operateInfo;

    private Goods goods;

    private Price price;
}
