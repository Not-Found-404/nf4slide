package cn.org.nf404.slide.server.repository.converter;

import cn.org.nf404.slide.server.domain.model.Folder;
import cn.org.nf404.slide.server.domain.model.Slide;
import cn.org.nf404.slide.server.domain.model.SlideContent;
import cn.org.nf404.slide.server.domain.model.User;
import cn.org.nf404.slide.server.repository.entity.FolderDO;
import cn.org.nf404.slide.server.repository.entity.SlideContentDO;
import cn.org.nf404.slide.server.repository.entity.SlideDO;
import cn.org.nf404.slide.server.repository.entity.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author dx DingXing
 * @since 2020-10-16
 */
@Mapper(componentModel = "spring", uses = JsonConverter.class)
public interface DoConverter {
    @Mapping(source = "extraJson", target = "extra")
    Folder convert(FolderDO folderDO);

    @Mapping(source = "extra", target = "extraJson")
    FolderDO convert(Folder folder);

    /**
     * do to model
     *
     * @param userDO UserDO
     * @return User
     */
    @Mapping(source = "extraJson", target = "extra")
    Slide convert(SlideDO userDO);

    /**
     * do to model
     *
     * @param userDO UserDO
     * @return User
     */
    @Mapping(source = "extraJson", target = "extra")
    SlideContent convert(SlideContentDO userDO);

    /**
     * model to do
     *
     * @param user User
     * @return UserDO
     */
    SlideDO convert(Slide user);

    SlideContentDO convert(SlideContent content);


    /**
     * do to model
     *
     * @param userDO UserDO
     * @return User
     */
    @Mapping(source = "tagJson", target = "tag")
    @Mapping(source = "roleJson", target = "role")
    @Mapping(source = "extraJson", target = "extra")
    User convert(UserDO userDO);

    /**
     * model to do
     *
     * @param user User
     * @return UserDO
     */
    @Mapping(source = "tag", target = "tagJson")
    @Mapping(source = "role", target = "roleJson")
    @Mapping(source = "extra", target = "extraJson")
    UserDO convert(User user);
}
