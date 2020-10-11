package cn.org.nf404.slide.server.repository.dao;

import cn.org.nf404.slide.server.repository.entity.FolderDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
/**
 * @author ghy ArcryGe
 * @version 1.0
 * @date 2020/10/11 16:05
 */
@Repository
public interface FolderDao extends JpaRepository<FolderDO, Long>, JpaSpecificationExecutor<FolderDO> {
}
