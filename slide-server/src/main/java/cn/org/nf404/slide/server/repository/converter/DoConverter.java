package cn.org.nf404.slide.server.repository.converter;

import cn.org.nf404.slide.server.domain.model.*;
import cn.org.nf404.slide.server.repository.entity.*;
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
     * Do to model
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

    /**
     * Model to do
     *
     * @param roster Roster
     * @return RosterDO
     */
    @Mapping(source = "extra", target = "extraJson")
    @Mapping(target = "groupId", source = "group.groupId")
    @Mapping(target = "groupName", source = "group.groupName")
    RosterDO convert(Roster roster);

    /**
     * Do to model
     *
     * @param roster RosterDO
     * @return Roster
     */
    @Mapping(source = "extraJson", target = "extra")
    @Mapping(source = "groupId", target = "group.groupId")
    @Mapping(source = "groupName", target = "group.groupName")
    Roster convert(RosterDO roster);

    /**
     * Do to model
     * @param roster RosterDO
     * @return RosterGroup
     */
    RosterGroup convertToGroup(RosterDO roster);
}
