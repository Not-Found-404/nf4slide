package cn.org.nf404.slide.api.response.order;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @date 2020-10-03
 */
@Data
public class OrderStatusInfo implements Serializable {
    private static final long serialVersionUID = -6512211827345738442L;

    private String payStatus;

    private String deliveryStatus;

}

