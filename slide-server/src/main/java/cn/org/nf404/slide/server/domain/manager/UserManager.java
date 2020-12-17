package cn.org.nf404.slide.server.domain.manager;

import cn.org.nf404.slide.server.domain.model.Folder;
import cn.org.nf404.slide.server.domain.model.User;
import cn.org.nf404.slide.server.repository.impl.FolderRepository;
import cn.org.nf404.slide.server.repository.impl.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ghy Arcry
 * @since 2020-10-12
 */
@Service
@AllArgsConstructor
public class UserManager {
    private final UserRepository userRepository;
    private final FolderRepository folderRepository;

    @Transactional(rollbackFor = Exception.class)
    public Long createUser(User toCreate, Folder folder){
        folder = folderRepository.create(folder);

        toCreate.setRootFolderId(folder.getId());

        Long id = this.userRepository.save(toCreate).getId();
        folder.setOwnerId(id);
        this.folderRepository.update(folder);
        return id;
    }

}
