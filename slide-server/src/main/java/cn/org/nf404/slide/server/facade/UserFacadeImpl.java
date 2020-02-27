package cn.org.nf404.slide.server.facade;

import cn.org.nf404.slide.api.facade.UserFacade;
import cn.org.nf404.slide.api.request.user.*;
import cn.org.nf404.slide.api.response.user.UserMetaData;
import cn.org.nf404.slide.api.response.user.UserThinResponse;
import cn.org.nf404.slide.common.model.request.Paging;
import cn.org.nf404.slide.common.model.request.Response;
import cn.org.nf404.slide.server.server.UserReadService;
import cn.org.nf404.slide.server.server.UserWriteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static cn.org.nf404.slide.common.utils.Invoker.invoke;

/**
 * @author dx DingXing
 * @date 2020-01-22
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {
    private final UserReadService readService;
    private final UserWriteService writeService;

    @Override
    public Response<String> login(UserLoginRequest request) {
        return invoke(request, param -> writeService.login(request.getType(), request.getMobile(), request.getPassword()));
    }

    @Override
    public Response<UserMetaData> getFromRedis(UserGetFromRedisRequest request) {
        return invoke(request, param -> readService.getUserFromRedis(request.getKey()));
    }

    @Override
    public Response<Boolean> existPhone(ExistPhoneRequest request) {
        return invoke(request, param -> readService.existPhone(request.getMobile()));
    }

    @Override
    public Response<Boolean> existEmail(ExistEmailRequest request) {
        return invoke(request, param -> readService.existEmail(request.getEmail()));
    }

    @Override
    public Response<Boolean> sendRegisterSms(UserSendRegisterSmsRequest request) {
        return invoke(request, param -> writeService.sendRegisterSms(request.getMobile()));
    }

    @Override
    public Response<UserThinResponse> findSingleUserInfoById(FindSingleUserRequest request) {
        return invoke(request, param -> writeService.findSingleUserInfoById(request.getUserId()));
    }

    @Override
    public Response<UserThinResponse> modifyUserInfo(UserModifyRequest request) {
        return invoke(request, param -> writeService.modifyUserInfo(request));
    }

    @Override
    public Response<Long> register(UserRegistryRequest request) {
        return invoke(request,param->writeService.register(request));
    }

    @Override
    public Response<Paging<UserThinResponse>> paging(UserPagingRequest request) {
        return null;
    }

    @Override
    public Response<Boolean> updateStatus(UserStatusUpdateRequest request) {
        return null;
    }

    @Override
    public Response<Boolean> sendLoginSms(UserSendLoginSmsRequest request) {
        return null;
    }

    @Override
    public Response<Long> smsLogin(UserSmsLoginRequest request) {
        return null;
    }

    @Override
    public Response<Boolean> logout(UserLogoutRequest request) {
        return null;
    }
}
