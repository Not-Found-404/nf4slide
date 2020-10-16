package cn.org.nf404.slide.common.utils;

import cn.org.nf404.slide.common.model.exception.ServiceException;

import java.util.Collection;
import java.util.List;

/**
 * @author dx DingXing
 * @since 2020-10-14
 */
public class AssertUtil {
    public static void nonExist(Object o, String error, Object... param) {
        if (o == null) {
            throw ServiceException.of(error + ".not.exist", param);
        }
    }

    @SuppressWarnings("unused")
    public static void nonEmpty(Collection c, String error, Object... param) {
        if (null == c || c.isEmpty()) {
            throw ServiceException.of(error + ".is.empty", param);
        }
    }
}
