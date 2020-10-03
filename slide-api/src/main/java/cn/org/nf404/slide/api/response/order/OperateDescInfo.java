package cn.org.nf404.slide.api.response.order;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dx DingXing
 * @date 2020-10-02
 */
@Data
public class OperateDescInfo implements Serializable {
    private static final long serialVersionUID = -1058502608460131264L;

    private Date paidAt;

    private Date deliveredAt;

    private Long acceptorId;

    private String acceptorName;

    private Long deliveryManId;

    private String deliveryManName;
}
