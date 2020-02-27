package cn.org.nf404.slide.server.domain.model;

import cn.org.nf404.slide.api.enums.UserTypeEnum;
import cn.org.nf404.slide.common.model.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户
 *
 * @author dx DingXing
 * @date 2020-01-11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseModel {
    private static final long serialVersionUID = 4690347459659334187L;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 类型
     */
    private UserTypeEnum type;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 姓名
     */
    private String name;

    /**
     * 角色
     */
    private String roleJson;

    /**
     * 标签
     */
    private String tagJson;
}
