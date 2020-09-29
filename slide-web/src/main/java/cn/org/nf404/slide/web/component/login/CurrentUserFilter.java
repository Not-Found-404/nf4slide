package cn.org.nf404.slide.web.component.login;

import cn.org.nf404.slide.api.response.user.UserMetaData;
import cn.org.nf404.slide.common.utils.JsonHelper;
import cn.org.nf404.slide.web.bean.constants.UserLoginConstant;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static cn.org.nf404.slide.web.component.login.RequestContext.setUser;
import static cn.org.nf404.slide.web.component.login.RequestContext.setUuid;


/**
 * @author DingXing wildhunt_geralt@foxmail.com
 * @date 2019/4/18
 */
@Component
@Slf4j
@WebFilter(urlPatterns = "/api/*", filterName = "currentUserFilter")
public class CurrentUserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String tokenValue = null;
        try {
            if (request instanceof HttpServletRequest) {
                HttpServletRequest httpRequest = (HttpServletRequest) request;
                Cookie[] cookies = httpRequest.getCookies();
                if (cookies != null) {
                    for (Cookie token : cookies) {
                        if (token != null && token.getName() != null && token.getName().equals(UserLoginConstant.UUID_PREFIX)) {
                            tokenValue = token.getValue();
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("failed to filter,cause:{}", Throwables.getStackTraceAsString(e));
        }
        setUuid(tokenValue);

        // TODO: 2020-09-28 先简单点
        if (request instanceof HttpServletRequest) {
            HttpSession session = ((HttpServletRequest) request).getSession();
            Object attribute = session.getAttribute(UserLoginConstant.USER_LOGIN_KEY);
            String userInfoJson = attribute != null ? attribute.toString() : null;
            UserMetaData userMetaData = JsonHelper.toObject(userInfoJson, UserMetaData.class);
            setUser(userMetaData);
        }

        chain.doFilter(request, response);
        RequestContext.destroy();
    }

    @Override
    public void destroy() {

    }
}
