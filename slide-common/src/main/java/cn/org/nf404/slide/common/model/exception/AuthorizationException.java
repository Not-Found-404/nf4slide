package cn.org.nf404.slide.common.model.exception;

/**
 * @author dx DingXing
 * @since 2020-01-01
 */
@SuppressWarnings("unused")
public class AuthorizationException extends RuntimeException {

    private static final long serialVersionUID = -2930146209344142410L;

    public AuthorizationException() {
    }

    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(Throwable cause) {
        super(cause);
    }

    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }
}