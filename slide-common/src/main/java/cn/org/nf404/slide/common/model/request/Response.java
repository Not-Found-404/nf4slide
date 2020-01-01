package cn.org.nf404.slide.common.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 基础Response类
 *
 * @author dx DingXing
 * @date 2020-01-01
 */
@Data
@SuppressWarnings("unused")
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 5723344170079564065L;
    private boolean success;

    private T result;

    private String error;

    private Integer code;

    public static final Integer SUCCESS_CODE = 200;
    public static final Integer SERVICE_ERROR = 500;
    public static final Integer ARGUMENT_ERROR = 400;
    public static final Integer NO_AUTH = 401;

    public static <T> Response<T> success(T t) {
        Response<T> response = new Response<>();
        response.setCode(SUCCESS_CODE);
        response.setResult(t);
        response.setSuccess(true);
        return response;
    }

    public static <T> Response<T> fail(String error) {
        Response<T> resp = new Response<>();
        resp.setError(error);
        resp.setCode(SERVICE_ERROR);
        return resp;
    }

    public static <T> Response<T> fail(String error, Integer code) {
        Response<T> resp = new Response<>();
        resp.setError(error);
        resp.setCode(code);
        return resp;
    }
}
