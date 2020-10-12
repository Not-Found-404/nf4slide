package cn.org.nf404.slide.api.facade;

import cn.org.nf404.slide.api.request.user.*;
import cn.org.nf404.slide.api.response.user.UserLoginInfo;
import cn.org.nf404.slide.api.response.user.UserMetaData;
import cn.org.nf404.slide.api.response.user.UserThinResponse;
import cn.org.nf404.slide.common.model.request.Paging;
import cn.org.nf404.slide.common.model.request.Response;

/**
 * @author dx DingXing
 * @since 2020-01-22
 */
@SuppressWarnings("unused")
public interface UserFacade {
    /**
     * login
     *
     * @param request request of login
     * @return token
     */
    Response<UserMetaData> login(UserLoginRequest request);

    Response<UserMetaData> getFromRedis(UserGetFromRedisRequest request);

    Response<Boolean> existPhone(ExistPhoneRequest request);

    Response<Boolean> existEmail(ExistEmailRequest request);

    Response<Boolean> sendRegisterSms(UserSendRegisterSmsRequest request);

    Response<UserThinResponse> findSingleUserInfoById(FindSingleUserRequest request);

    Response<UserThinResponse> modifyUserInfo(UserModifyRequest request);

    Response<Long> register(UserRegistryRequest request);

    Response<Paging<UserThinResponse>> paging(UserPagingRequest request);

    Response<Boolean> updateStatus(UserStatusUpdateRequest request);

    Response<Boolean> sendLoginSms(UserSendLoginSmsRequest request);

    Response<Long> smsLogin(UserSmsLoginRequest request);

    Response<Boolean> logout(UserLogoutRequest request);
}
