package cn.org.nf404.slide.server.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "dealer")
public class DealerDO extends BaseDO{

    private static final long serialVersionUID = 2088188621795058095L;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 创建时间
     */
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "endpoint_address_id")
    private Long endpointAddressId;

    @Column(name = "detail_address")
    private String detailAddress;

    @Column(name = "full_detail_address")
    private String fullDetailAddress;

    @Column(name = "phone")
    private String phone;

    @Column(name = "remark")
    private String remark;

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
