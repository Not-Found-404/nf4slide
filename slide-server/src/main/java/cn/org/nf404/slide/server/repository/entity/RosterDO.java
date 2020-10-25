package cn.org.nf404.slide.server.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * @author dx DingXing
 * @since 2020-10-25
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "roster", indexes = {
        @Index(name = "idx_group_id", columnList = "group_id"),
        @Index(name = "idx_roster_no", columnList = "roster_no")}
)
public class RosterDO extends BaseDO{
    private static final long serialVersionUID = -573937989664605326L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 所属组id
     */
    @Column(name = "group_id", nullable = false,columnDefinition = "varchar(32) not null")
    private String groupId;

    /**
     * 所属组名字
     */
    @Column(name = "group_name", nullable = false,columnDefinition = "varchar(15) not null")
    private String groupName;

    /**
     * 姓名
     */
    @Column(name = "name", nullable = false,columnDefinition = "varchar(15) not null")
    private String name;

    /**
     * 编号
     */
    @Column(name = "roster_no", nullable = false,columnDefinition = "varchar(32) not null")
    private String rosterNo;

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
