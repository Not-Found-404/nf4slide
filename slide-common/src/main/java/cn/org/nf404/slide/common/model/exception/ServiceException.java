package cn.org.nf404.slide.common.model.exception;

import lombok.Getter;

/**
 * @author dx DingXing
 * @since 2020-01-01
 */
@SuppressWarnings("unused")
@Getter
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 6608000317844211554L;

    private Object[] params;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public static ServiceException of(String error, Object... params) {
        ServiceException serviceException = new ServiceException(error);
        serviceException.params = params;
        return serviceException;
    }
}