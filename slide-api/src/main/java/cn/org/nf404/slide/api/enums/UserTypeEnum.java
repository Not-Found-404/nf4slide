package cn.org.nf404.slide.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dx DingXing
 * @date 2020-01-22
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {
    /**
     * 普通用户
     */
    USER(1),
    /**
     * 管理员
     */
    ADMIN(100);

    /**
     * 权限等级
     */
    private final int level;
}
