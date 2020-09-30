package cn.org.nf404.slide.server.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "fulfillment_order_line",
        indexes = {
                @Index(name = "idx_order_id", columnList = "fulfillment_order_id"),
                @Index(name = "idx_dealer_goods_id", columnList = "dealer_id,goods_id"),
                @Index(name = "idx_dev_at", columnList = "delivered_at")
        }
)
public class FulfillmentOrderLineDO extends BaseDO implements Serializable {
    private static final long serialVersionUID = -4355064791453885996L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fulfillment_order_id", nullable = false)
    private Long fulfillmentOrderId;

    @Column(name = "dealer_id", nullable = false)
    private Long dealerId;

    @Column(name = "goods_id", nullable = false)
    private Long goodsId;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "paid_amount", nullable = false)
    private Long paidAmount;

    @Column(name = "original_amount", nullable = false)
    private Long originalAmount;

    @Column(name = "paid_at")
    private Date paidAt;

    @Column(name = "delivered_at")
    private Date deliveredAt;

    @Column(name = "acceptor_id")
    private Long acceptorId;

    @Column(name = "acceptor_name")
    private String acceptorName;

    @Column(name = "delivery_man_id")
    private Long deliveryManId;

    @Column(name = "delivery_man_name")
    private String deliveryManName;


    /**
     * 创建时间
     */
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    /**
     * 更新时间
     */
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    /**
     * 状态
     */
    @Column(name = "status", nullable = false)
    private String status;

    /**
     * 额外信息
     */
    @Column(name = "extra_json")
    private String extraJson;
}
