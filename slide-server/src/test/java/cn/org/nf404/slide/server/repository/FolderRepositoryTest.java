package cn.org.nf404.slide.server.repository;

import cn.org.nf404.slide.api.enums.OwnerTypeEnum;
import cn.org.nf404.slide.common.model.enums.ModelStatusEnum;
import cn.org.nf404.slide.server.BaseTest;
import cn.org.nf404.slide.server.domain.model.Folder;
import cn.org.nf404.slide.server.repository.impl.FolderRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ghy Arcry
 * @since 2020-10-12
 */
public class FolderRepositoryTest extends BaseTest {
    @Autowired
    private FolderRepository folderRepository;

    @Test
    public void findById() {
        //Folder folder = this.random.nextObject(Folder.class);
        Folder folder = new Folder();
        folder.setLevel(1);
        folder.setName("test");
        folder.setPid(1L);
        folder.setChildren(null);
        folder.setOwnerId(1L);
        folder.setOwnerType(OwnerTypeEnum.USER);
        folder.setId(1L);
        folder = this.folderRepository.create(folder);
        assert folder != null;

        Folder findById = this.folderRepository.findById(folder.getId());
        assert findById != null;
    }

    @Test
    public void updateByFolder() {
        Folder folder = new Folder();
        folder.setLevel(1);
        folder.setName("test");
        folder.setPid(1L);
        folder.setChildren(null);
        folder.setOwnerId(1L);
        folder.setOwnerType(OwnerTypeEnum.USER);
        folder.setId(1L);
        folder.setStatus(ModelStatusEnum.NORMAL);
        folder = this.folderRepository.create(folder);
        assert folder != null;

        folder.setName("after modify name");
        Folder update = this.folderRepository.update(folder);
        assert update != null;

        Folder byId = this.folderRepository.findById(update.getId());
        assert "after modify name".equals(byId.getName());
    }

}
