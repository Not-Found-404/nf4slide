package cn.org.nf404.slide.web.aop;

import org.springframework.http.HttpStatus;

/**
 * @author dx DingXing
 * @since 2020-01-01
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class RestException extends RuntimeException {
    private static final long serialVersionUID = 1881695577343613691L;

    public final HttpStatus httpStatus;

    public final String message;

    public final String[] params;

    public RestException(String message, String... params) {
        this(HttpStatus.OK, message, params);
    }

    public RestException(HttpStatus httpStatus, String message, String... params) {

        super(message);

        this.httpStatus = httpStatus;
        this.message = message;
        this.params = params;
    }

}