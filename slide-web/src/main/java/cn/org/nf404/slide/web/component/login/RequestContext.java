package cn.org.nf404.slide.web.component.login;

import cn.org.nf404.slide.api.response.user.UserMetaData;
import cn.org.nf404.slide.common.model.exception.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author dx DingXing
 * @date 2020-09-28
 */
@Component
public class RequestContext {
    private static UserLoginComponent loginComponent;

    private static ThreadLocal<String> uuid = new ThreadLocal<>();

    private static ThreadLocal<UserMetaData> uuidToUser = new ThreadLocal<>();

    public static Long getUserId() {
        return Objects.requireNonNull(assertUserExist(getCurrentUser())).getUserId();
    }

    @Autowired
    public void setLoginComponent(UserLoginComponent component) {
        loginComponent = component;
    }

    private static UserMetaData getCurrentUser() {
        UserMetaData user = uuidToUser.get();
        return Objects.nonNull(user) ?
                user :
                Objects.nonNull(uuid.get()) ?
                        getAndSetUser() :
                        null;
    }

    private static UserMetaData getAndSetUser() {
        UserMetaData user = loginComponent.getUserByUuid(uuid.get());
        uuidToUser.set(user);
        return user;
    }

    private static UserMetaData assertUserExist(UserMetaData userMetaData) {
        if (Objects.isNull(userMetaData)) {
            throw new AuthorizationException("not.login");
        }
        return userMetaData;
    }

    static void setUuid(String tokenValue) {
        uuid.set(tokenValue);
        uuidToUser.set(null);
    }

    static void setUser(UserMetaData user) {
        uuidToUser.set(user);
    }

    static void destroy() {
        uuid.remove();
        uuidToUser.remove();
    }

}