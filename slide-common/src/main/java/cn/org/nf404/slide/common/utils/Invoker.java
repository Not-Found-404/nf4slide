package cn.org.nf404.slide.common.utils;

import cn.org.nf404.slide.common.model.exception.ServiceException;
import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.model.request.Response;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

/**
 * @author dx DingXing
 * @date 2020-01-23
 */
@Slf4j
public final class Invoker {
    public static <P, R> Response<R> invoke(P param, Function<P, R> function) {
        try {
            checkParam(param);
            return Response.success(function.apply(param));
        } catch (Throwable e) {
            return logAndResponseFail(e, param);
        }
    }

    private static <R, P> Response<R> logAndResponseFail(Throwable e, P param) {
        log.error("failed to {} by {}, cause:{}", "", param, Throwables.getStackTraceAsString(e));
        if (e instanceof IllegalArgumentException) {
            return Response.fail(e.getMessage(), Response.ARGUMENT_ERROR);
        } else if (e instanceof ServiceException) {
            return Response.fail(e.getMessage(), Response.SERVICE_ERROR);
        } else {
            return Response.fail("error");
        }
    }

    private static <P> void checkParam(P param) {
        if (param instanceof AbstractRequest) {
            AbstractRequest abstractRequest = (AbstractRequest) param;
            log.info("Request:{}.Value:{}", abstractRequest.getOperationType().name(), abstractRequest.toString());
            abstractRequest.checkParam();
        }
    }
}