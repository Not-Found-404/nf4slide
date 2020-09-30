package cn.org.nf404.slide.api.request.fulfillment;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @date 2020-09-30
 */
@Data
public class FulfillmentOrderLineCreateParam implements Serializable {
    private static final long serialVersionUID = 5422859023198175066L;

    private Long goodsId;

    private Long quantity;

    private Long paidAmount;
}
