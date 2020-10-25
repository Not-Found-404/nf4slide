package cn.org.nf404.slide.server.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author dx DingXing
 * @since 2020-09-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user",
        indexes = {@Index(name = "idx_phone", columnList = "phone")}
)
public class UserDO extends BaseDO implements Serializable {
    private static final long serialVersionUID = -8531948139305993443L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户默认根目录id
     */
    @Column(name = "root_folder_id")
    private Long rootFolderId;

    /**
     * 昵称
     */
    @Column(name = "nickname")
    private String nickname;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 手机号
     */
    @Column(name = "phone", columnDefinition = "varchar(20) not null")
    private String phone;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 类型
     */
    @Column(name = "type")
    private String type;

    /**
     * 头像
     */
    @Column(name = "avatar")
    private String avatar;

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 角色
     */
    @Column(name = "role_json")
    private String roleJson;

    /**
     * 标签
     */
    @Column(name = "tag_json")
    private String tagJson;

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
