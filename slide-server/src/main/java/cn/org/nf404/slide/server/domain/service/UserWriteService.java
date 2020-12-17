package cn.org.nf404.slide.server.domain.service;

import cn.org.nf404.slide.api.constants.FolderConstant;
import cn.org.nf404.slide.api.enums.OwnerTypeEnum;
import cn.org.nf404.slide.api.enums.UserTypeEnum;
import cn.org.nf404.slide.api.request.user.UserModifyRequest;
import cn.org.nf404.slide.api.request.user.UserRegistryRequest;
import cn.org.nf404.slide.api.response.user.UserMetaData;
import cn.org.nf404.slide.api.response.user.UserThinResponse;
import cn.org.nf404.slide.common.model.exception.ServiceException;
import cn.org.nf404.slide.server.domain.manager.UserManager;
import cn.org.nf404.slide.server.domain.model.Folder;
import cn.org.nf404.slide.server.domain.model.User;
import cn.org.nf404.slide.server.repository.impl.FolderRepository;
import cn.org.nf404.slide.server.repository.impl.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author dx DingXing
 * @since 2020-01-23
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserWriteService {

    private final UserRepository userRepository;

    private final UserManager userManager;

    public UserMetaData login(String mobile, String password) {
        User user = userRepository.findByPhoneAndPass(mobile, password);
        if (null == user) {
            throw ServiceException.of("user.or.password.error", mobile, password);
        }

        return UserMetaData.builder()
                .userId(user.getId())
                .build();
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
        // TODO: 2020-09-28 check before save


        User toCreate = new User();

        toCreate.setPhone(request.getPhone());
        toCreate.setPassword(request.getPassword());
        toCreate.setType(UserTypeEnum.USER);

        Folder folder = new Folder();
        folder.setLevel(FolderConstant.ROOT_LEVEL);
        folder.setOwnerId(-1L);
        folder.setOwnerType(OwnerTypeEnum.USER);
        folder.setName("root folder");
        folder.setPid(FolderConstant.PID);

        return userManager.createUser(toCreate,folder);
    }
}
