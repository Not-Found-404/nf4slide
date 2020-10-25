package cn.org.nf404.slide.server.repository.dao;

import cn.org.nf404.slide.server.repository.entity.RosterDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dx DingXing
 * @since 2020-10-25
 */
@Repository
public interface RosterDao extends JpaRepository<RosterDO, Long>, JpaSpecificationExecutor<RosterDO> {
    /**
     * Find roster by group id
     *
     * @param groupId Id of group
     * @return List of RosterDO
     */
    List<RosterDO> findByGroupId(String groupId);

    /**
     * Query groups
     *
     * @return List of record
     */
    @Query(value = "select * from roster group by group_id", nativeQuery = true)
    List<RosterDO> findGroups();
}

