package cn.org.nf404.slide.server.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * @author dx DingXing
 * @since 2020-10-06
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "slide", indexes = {
        @Index(name = "idx_library_id", columnList = "library_id"),
        @Index(name = "idx_folder_id", columnList = "folder_id")}
)
public class SlideDO extends BaseDO {
    private static final long serialVersionUID = 6592915757904354649L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 文件库id
     */
    @Column(name = "library_id")
    private Long libraryId;

    /**
     * 目录id
     */
    @Column(name = "folder_id")
    private Long folderId;

    /**
     * 幻灯片名
     */
    @Column(name = "name")
    private String name;

    /**
     * 键鼠信息
     */
    @Column(name = "description")
    private String description;

    /**
     * 访问等级
     */
    @Column(name = "access_level")
    private String accessLevel;

    /**
     * 乐观锁
     */
    @Column(name = "version")
    private Integer version;

    /**
     * 编辑参与人
     */
    @Column(name = "authors")
    private String authors;

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
