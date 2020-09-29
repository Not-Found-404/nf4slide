package cn.org.nf404.slide.server.repository.dao;


import cn.org.nf404.slide.server.repository.entity.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author dx DingXing
 * @date 2020-09-28
 */
@Repository
public interface UserDao extends JpaRepository<UserDO, Long>, JpaSpecificationExecutor<UserDO> {
}