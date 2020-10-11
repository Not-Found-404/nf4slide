package cn.org.nf404.slide.server.repository.dao;

import cn.org.nf404.slide.server.repository.entity.SlideContentDO;
import cn.org.nf404.slide.server.repository.entity.SlideDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author dx DingXing
 * @date 2020-10-06
 */
@Repository
public interface SlideContentDao extends JpaRepository<SlideContentDO, Long>, JpaSpecificationExecutor<SlideContentDO> {
}
