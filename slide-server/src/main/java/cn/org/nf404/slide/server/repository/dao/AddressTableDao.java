package cn.org.nf404.slide.server.repository.dao;

import cn.org.nf404.slide.server.repository.entity.AddressTableDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Repository
public interface AddressTableDao  extends JpaRepository<AddressTableDO, Long>, JpaSpecificationExecutor<AddressTableDO> {
}
