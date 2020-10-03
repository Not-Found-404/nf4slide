package cn.org.nf404.slide.web.bean.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @date 2020-10-02
 */
@Data
public class FulfillmentOrderDetailRequestDTO implements Serializable {
    private static final long serialVersionUID = -1042484921059660387L;

    private Long fulfillmentOrderId;
}
