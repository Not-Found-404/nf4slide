package cn.org.nf404.slide.common.utils;

import cn.org.nf404.slide.common.model.exception.ServiceException;

/**
 * @author dx DingXing
 * @since 2020-10-14
 */
@SuppressWarnings("unused")
public class AssertUtil {
    public static void nonExist(Object o, String error, Object... param) throws IllegalArgumentException {
        if (o == null) {
            throw ServiceException.of(error + ".not.exist", param);
        }
    }
}
