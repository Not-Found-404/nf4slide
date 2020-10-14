package cn.org.nf404.slide.common.utils;


import cn.org.nf404.slide.common.model.exception.AuthorizationException;
import cn.org.nf404.slide.common.model.exception.RestException;
import cn.org.nf404.slide.common.model.exception.ServiceException;
import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.model.request.Response;
import com.google.common.base.Throwables;
import com.sun.xml.internal.ws.client.RequestContext;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.function.Function;

/**
 * 基础model类
 *
 * @author dx DingXing
 * @since 2020-01-01
 */
@Slf4j
@SuppressWarnings("unused")
public final class FacadeInvoker {
    public static <T extends AbstractRequest, R> R invoke(Function<T, Response<R>> facade, T request, String errorDesc) {
        try {
            Response<R> apply = facade.apply(request);
            if (apply.isSuccess()) {
                return apply.getResult();
            } else {
                throw new RestException(apply.getError());
            }
        } catch (RestException e) {
            log.error("failed to execute:{}, request:{}, error:{}", errorDesc, request, e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("failed to execute:{}, request:{}, cause:{}", errorDesc, request, Throwables.getStackTraceAsString(e));
            throw new RestException(e.getMessage());
        }
    }

    public static <T extends AbstractRequest, R> R invoke(Function<T, Response<R>> function, T request) {
        try {
            Response<R> apply = function.apply(request);
            if (apply.isSuccess()) {
                return apply.getResult();
            } else {
                throw new RestException(apply.getError());
            }
        } catch (RestException e) {
            log.error("failed to execute:{}, \nrequest:{}, error:{}", request.getOperationType().getDescription(), JsonHelper.toJson(request), e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("failed to execute:{}, \nrequest:{}, cause:{}", request.getOperationType().getDescription(), JsonHelper.toJson(request), Throwables.getStackTraceAsString(e));
            throw new RestException(e.getMessage());
        }
    }

    public static <T> T sortResponse(Response<T> response) {
        return response.isSuccess() ? response.getResult() : null;
    }

    public static void isExist(Object o, String error) throws ServiceException {
        if (o == null) {
            throw new ServiceException(error + ".not.exist");
        }
    }

    private static void throwExceptionByError(Response response) {
        Integer code = response.getCode();
        code = Objects.isNull(code) ? Response.SERVICE_ERROR : code;
        if (code.equals(Response.ARGUMENT_ERROR)) {
            throw new IllegalArgumentException(response.getError());
        } else if (code.equals(Response.SERVICE_ERROR)) {
            throw new ServiceException(response.getError());
        } else if (code.equals(Response.NO_AUTH)) {
            throw new AuthorizationException(response.getError());
        } else {
            throw new ServiceException(response.getError());
        }
    }
}
