package cn.org.nf404.slide.server.domain.model;

import cn.org.nf404.slide.common.model.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 团队
 *
 * @author dx DingXing
 * @since 2020-01-11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Team extends BaseModel {
    private static final long serialVersionUID = -4985461558237271522L;
    /**
     * 团队名
     */
    private String name;
    /**
     * 拥有者id
     */
    private Long ownerId;
    /**
     * 简述
     */
    private String description;
    /**
     * 访问等级
     */
    private String accessLevel;
    /**
     * 成员数量
     */
    private Integer memberAmount;
}
