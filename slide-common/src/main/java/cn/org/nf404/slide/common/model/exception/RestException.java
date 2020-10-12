package cn.org.nf404.slide.common.model.exception;

/**
 * @author dx DingXing
 * @since 2020-01-01
 */
@SuppressWarnings("unused")
public class RestException extends RuntimeException {

    private static final long serialVersionUID = -2702211438037543600L;

    public RestException() {
    }

    public RestException(String message) {
        super(message);
    }

    public RestException(Throwable cause) {
        super(cause);
    }

    public RestException(String message, Throwable cause) {
        super(message, cause);
    }
}