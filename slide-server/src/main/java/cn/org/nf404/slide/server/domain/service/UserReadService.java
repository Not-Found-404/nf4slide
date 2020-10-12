package cn.org.nf404.slide.server.domain.service;

import cn.org.nf404.slide.api.response.user.UserMetaData;
import cn.org.nf404.slide.common.model.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author dx DingXing
 * @since 2020-01-22
 */
@Slf4j
@Service
@SuppressWarnings("unused")
public class UserReadService {

    public UserMetaData getUserFromRedis(String key) {
        throw new ServiceException("not.impl");
    }

    public Boolean existEmail(String email) {
        throw new ServiceException("not.impl");
    }

    public Boolean existPhone(String mobile) {
        throw new ServiceException("not.impl");
    }
}
