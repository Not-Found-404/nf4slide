package cn.org.nf404.slide.server.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * @author dx DingXing
 * @date 2020-10-06
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "slide_content")
public class SlideContentDO extends BaseDO {
    private static final long serialVersionUID = -322489041320485429L;


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * 幻灯片id
     */
    @Column(name = "slide_id")
    private Long slideId;

    /**
     * 幻灯片名
     */
    @Column(name = "slide_name")
    private String slideName;

    @Column(name = "content_type")
    private String contentType;

    /**
     * 幻灯片内容
     */
    @Column(name = "content_text")
    private String contentText;

    /**
     * url
     */
    @Column(name = "content_url")
    private String contextUrl;

    /**
     * 乐观锁
     */
    @Column(name = "version")
    private Integer version;

    @Column(name = "config_json")
    private String configJson;

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
