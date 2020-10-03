package cn.org.nf404.slide.server.domain.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Data
public class OperateDesc implements Serializable {
    private static final long serialVersionUID = -6573535173069881420L;

    private Date paidAt;

    private Date deliveredAt;

    private Long acceptorId;

    private String acceptorName;

    private Long deliveryManId;

    private String deliveryManName;
}
