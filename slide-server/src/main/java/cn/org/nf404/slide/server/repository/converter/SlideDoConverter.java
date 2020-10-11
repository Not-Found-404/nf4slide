package cn.org.nf404.slide.server.repository.converter;

import cn.org.nf404.slide.server.domain.model.Slide;
import cn.org.nf404.slide.server.domain.model.SlideContent;
import cn.org.nf404.slide.server.repository.entity.SlideContentDO;
import cn.org.nf404.slide.server.repository.entity.SlideDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author dx DingXing
 * @date 2020-09-28
 */
@Mapper(componentModel = "spring", uses = JsonConverter.class)
public interface SlideDoConverter {

    /**
     * do to model
     *
     * @param userDO UserDO
     * @return User
     */
    @Mapping(source = "extraJson", target = "extra")
    Slide do2Model(SlideDO userDO);

    /**
     * do to model
     *
     * @param userDO UserDO
     * @return User
     */
    @Mapping(source = "extraJson", target = "extra")
    SlideContent do2Model(SlideContentDO userDO);

    /**
     * model to do
     *
     * @param user User
     * @return UserDO
     */
    @Mapping(source = "tag", target = "tagJson")
    SlideDO model2Do(Slide user);

    @Mapping(source = "tag", target = "tagJson")
    SlideContentDO model2Do(SlideContent content);
}
