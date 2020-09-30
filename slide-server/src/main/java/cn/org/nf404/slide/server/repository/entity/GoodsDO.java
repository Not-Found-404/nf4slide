package cn.org.nf404.slide.server.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "goods")
public class GoodsDO extends BaseDO implements Serializable {
    private static final long serialVersionUID = -7595923765046454466L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "barcode")
    private String barcode;


    @Column(name = "stock_inventory")
    private Long stockInventory;

    @Column(name = "original_amount")
    private Long originalAmount;

    @Column(name = "unit")
    private String unit;

    @Column(name = "attribute_json")
    private String attributeJson;

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
