package cn.org.nf404.slide.web.component.login;

import cn.org.nf404.slide.api.facade.UserFacade;
import cn.org.nf404.slide.api.request.user.UserLoginRequest;
import cn.org.nf404.slide.api.response.user.UserMetaData;
import cn.org.nf404.slide.web.aop.FacadeInvoker;
import cn.org.nf404.slide.common.utils.JsonHelper;
import cn.org.nf404.slide.web.bean.dto.user.UserLoginRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static cn.org.nf404.slide.web.aop.FacadeInvoker.invoke;
import static cn.org.nf404.slide.web.bean.constants.UserLoginConstant.USER_LOGIN_KEY;

/**
 * @author dx DingXing
 * @since 2020-09-28
 */
@Component
@AllArgsConstructor
public class UserLoginComponent {
    private final UserFacade userFacade;

    public UserMetaData login(HttpServletRequest servletRequest, UserLoginRequestDTO requestDTO) {
        UserLoginRequest request = UserLoginRequest.builder()
                .mobile(requestDTO.getIdentify())
                .password(requestDTO.getToken())
                .build();

        UserMetaData userLoginInfo = FacadeInvoker.invoke(userFacade::login, request);
        this.bindUuidToUserId(servletRequest, userLoginInfo);
        return userLoginInfo;
    }


    private void bindUuidToUserId(HttpServletRequest servletRequest, UserMetaData userLoginInfo) {
        // TODO: 2020-09-28 通过redis实现
        HttpSession session = servletRequest.getSession();
        session.setAttribute(USER_LOGIN_KEY, JsonHelper.toJson(userLoginInfo));
    }

    UserMetaData getUserByUuid(String s) {
        // TODO: 2020-09-28 通过redis实现
        return null;
    }
}
