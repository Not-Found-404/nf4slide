package cn.org.nf404.slide.server.domain.model;

import cn.org.nf404.slide.common.model.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 团队用户绑定
 *
 * @author dx DingXing
 * @date 2020-01-11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TeamUserBinding extends BaseModel {
    private static final long serialVersionUID = 3181602769138565014L;

    /**
     * 团队id
     */
    private Long teamId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 访问等级
     */
    private String accessLevel;

}
