package cn.org.nf404.slide.server.domain.model;

import cn.org.nf404.slide.api.enums.DeliveryStatusEnum;
import cn.org.nf404.slide.api.enums.PayStatusEnum;
import lombok.Data;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Data
public class OrderStatus {
    private PayStatusEnum payStatus;

    private DeliveryStatusEnum deliveryStatus;

    public static OrderStatus init() {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setDeliveryStatus(DeliveryStatusEnum.UN_DELIVERY);
        orderStatus.setPayStatus(PayStatusEnum.UNPAID);
        return orderStatus;
    }
}
