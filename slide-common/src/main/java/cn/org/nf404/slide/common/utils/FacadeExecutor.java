package cn.org.nf404.slide.common.utils;

import cn.org.nf404.slide.common.model.exception.ServiceException;
import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.model.request.Response;
import com.google.common.base.Stopwatch;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author dx DingXing
 * @date 2020-01-23
 */
@Slf4j
public final class FacadeExecutor {
    public static <P, R> Response<R> execute(P param, Function<P, R> function) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            checkParam(param);
            return Response.success(function.apply(param));
        } catch (Throwable e) {
            return logAndResponseFail(e, param);
        } finally {
            stopwatch.stop();
            long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
            String name = "";
            if (param instanceof AbstractRequest) {
                name = ((AbstractRequest) param).getOperationType().name();
            }
            log.info("DUMP :{} over, cost:{}", name, elapsed);
        }
    }

    private static <R, P> Response<R> logAndResponseFail(Throwable e, P param) {
        log.error("failed to {} by {}, cause:{}", "", param, Throwables.getStackTraceAsString(e));
        if (e instanceof IllegalArgumentException) {
            log.error("failed to execute:{}, error:{}", "", e.getMessage());
            return Response.fail(e.getMessage(), Response.ARGUMENT_ERROR);
        } else if (e instanceof ServiceException) {
            log.error("failed to execute:{}, error:{}, params:{}", "", e.getMessage(), ((ServiceException) e).getParams());
            return Response.fail(e.getMessage(), Response.SERVICE_ERROR);
        } else {
            log.error("failed to execute:{}, cause:{}", "", Throwables.getStackTraceAsString(e));
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