package cn.org.nf404.slide.web.aop;

import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @author dx DingXing
 * @since 2020-10-14
 */
@SuppressWarnings("unused")
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    private final LocaleResolver localResolver;

    @Autowired
    public RestExceptionHandler(MessageSource messageSource,
                                LocaleResolver localResolver) {
        this.messageSource = messageSource;
        this.localResolver = localResolver;
    }

    /**
     * 处理RestException
     *
     * @param ex      异常实例
     * @param request http请求对象
     * @return 返回结果
     */
    @ExceptionHandler(RestException.class)
    protected ResponseEntity<Object> onRestException(RestException ex, HttpServletRequest request) {
        Locale locale = localResolver.resolveLocale(request);
        String error = messageSource.getMessage(ex.message, ex.params, ex.message, locale);
        error = Strings.isNullOrEmpty(error) ? "system.error" : error;
        return new ResponseEntity<>(ImmutableMap.of("error", error, "success", false), ex.httpStatus);
    }

    @ExceptionHandler({Exception.class})
    protected ResponseEntity<Object> onException(Exception ignore, HttpServletRequest request) {
        log.error("invoke error:{}", Throwables.getStackTraceAsString(ignore));
        Locale locale = this.localResolver.resolveLocale(request);
        String error = this.messageSource.getMessage("server.error", new String[0], "server.error", locale);
        error = Strings.isNullOrEmpty(error) ? "system.error" : error;
        return new ResponseEntity<>(ImmutableMap.of("error", error, "success", false),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
