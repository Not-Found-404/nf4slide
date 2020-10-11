package cn.org.nf404.slide.server.repository.converter;

import cn.org.nf404.slide.server.domain.model.Folder;
import cn.org.nf404.slide.server.repository.entity.FolderDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author ghy ArcryGe
 * @version 1.0
 * @date 2020/10/11 16:05
 */
@Mapper(componentModel = "spring", uses = JsonConverter.class)
public interface FolderDoConverter {
    @Mapping(source = "extraJson", target = "extra")
    Folder do2Model(FolderDO folderDO);

    @Mapping(source = "extra", target = "extraJson")
    FolderDO moder2Do(Folder folder);
}
