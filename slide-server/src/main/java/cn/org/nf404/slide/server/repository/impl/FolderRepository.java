package cn.org.nf404.slide.server.repository.impl;

import cn.org.nf404.slide.common.model.enums.ModelStatusEnum;
import cn.org.nf404.slide.server.domain.model.Folder;
import cn.org.nf404.slide.server.repository.converter.DoConverter;
import cn.org.nf404.slide.server.repository.dao.FolderDao;
import cn.org.nf404.slide.server.repository.entity.BaseDO;
import cn.org.nf404.slide.server.repository.entity.FolderDO;
import lombok.AllArgsConstructor;
import org.mvel2.ast.Fold;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

/**
 * @author ghy ArcryGe
 * @version 1.0
 * @since 2020/10/11 16:05
 */
@Repository
@AllArgsConstructor
public class FolderRepository {
    private final FolderDao folderDao;
    private final DoConverter folderDoConverter;

    public Folder findById(Long id) {
        Optional<FolderDO> byId = this.folderDao.findById(id);
        FolderDO folderDO = byId.orElse(null);
        return this.folderDoConverter.convert(folderDO);
    }

    public Folder creat(Folder folder) {
        FolderDO folderDO = this.folderDoConverter.convert(folder);
        BaseDO.init(folderDO);
        FolderDO save = this.folderDao.save(folderDO);
        return this.folderDoConverter.convert(save);
    }

    public Folder update(Folder folder){
        FolderDO folderDO = this.folderDoConverter.convert(folder);
        BaseDO.init(folderDO);
        folderDO.setUpdatedAt(new Date());
        folder.setStatus(ModelStatusEnum.DELETE);

        FolderDO save = this.folderDao.save(folderDO);
        return this.folderDoConverter.convert(save);
    }


}
