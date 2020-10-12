package cn.org.nf404.slide.common.model.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dx DingXing
 * @since 2020-01-01
 */
@SuppressWarnings("unused")
@AllArgsConstructor
@Getter
public enum ModelStatusEnum {
    /**
     * 已删除
     */
    DELETE(-3),
    /**
     * 初始化
     */
    INIT(0),
    /**
     * 正常
     */
    NORMAL(1);

    private Integer code;

    public static ModelStatusEnum fromCode(Integer code) {
        if (null == code) {
            throw new IllegalArgumentException("illegal.model.status.code");
        }
        for (ModelStatusEnum e : ModelStatusEnum.values()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        throw new IllegalArgumentException("illegal.model.status.code");
    }
}