package cn.org.nf404.slide.server.server;

import cn.org.nf404.slide.api.request.user.UserModifyRequest;
import cn.org.nf404.slide.api.request.user.UserRegistryRequest;
import cn.org.nf404.slide.api.response.user.UserThinResponse;
import cn.org.nf404.slide.common.model.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author dx DingXing
 * @date 2020-01-23
 */
@Slf4j
@Service
public class UserWriteService {
    public String login(Integer type, String mobile, String password) {
        throw new ServiceException("not.impl");
    }

    public Boolean sendRegisterSms(String mobile) {
        throw new ServiceException("not.impl");
    }

    public UserThinResponse findSingleUserInfoById(Long userId) {
        throw new ServiceException("not.impl");
    }

    public UserThinResponse modifyUserInfo(UserModifyRequest request) {
        throw new ServiceException("not.impl");
    }

    public Long register(UserRegistryRequest request) {
        throw new ServiceException("not.impl");
    }
}
