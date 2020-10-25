package cn.org.nf404.slide.server.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ghy ArcryGe
 * @since 2020/10/11 16:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "folder", indexes = {
        @Index(name = "idx_owner_id", columnList = "owner_id,owner_type"),
        @Index(name = "idx_pid", columnList = "pid")}
)
public class FolderDO extends BaseDO {
    private static final long serialVersionUID = 7378941016382670038L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 层级
     */
    @Column(name = "level", nullable = false)
    private Integer level;

    /**
     * folder对应ownerType对应对id
     */
    @Column(name = "owner_id",nullable = false)
    private Long ownerId;

    /**
     * 当前folder对应对类型
     */
    @Column(name="owner_type",nullable = false)
    private String ownerType;

    /**
     * 目录名
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 父目录id
     */
    @Column(name = "pid", nullable = false)
    private Long pid;

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
