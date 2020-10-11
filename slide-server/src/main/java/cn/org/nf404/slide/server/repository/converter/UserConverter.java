package cn.org.nf404.slide.server.repository.converter;

import cn.org.nf404.slide.server.domain.model.User;
import cn.org.nf404.slide.server.repository.entity.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author dx DingXing
 * @date 2020-09-28
 */
@Mapper(componentModel = "spring", uses = JsonConverter.class)
public interface UserConverter {

    /**
     * do to model
     *
     * @param userDO UserDO
     * @return User
     */
    @Mapping(source = "tagJson", target = "tag")
    @Mapping(source = "roleJson", target = "role")
    @Mapping(source = "extraJson", target = "extra")
    User do2Model(UserDO userDO);

    /**
     * model to do
     *
     * @param user User
     * @return UserDO
     */
    @Mapping(source = "tag", target = "tagJson")
    @Mapping(source = "role", target = "roleJson")
    @Mapping(source = "extra", target = "extraJson")
    UserDO model2Do(User user);
}
