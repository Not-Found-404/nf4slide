package cn.org.nf404.slide.common.model.exception;

/**
 * @author dx DingXing
 * @date 2020-01-01
 */
@SuppressWarnings("unused")
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 6608000317844211554L;

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
}