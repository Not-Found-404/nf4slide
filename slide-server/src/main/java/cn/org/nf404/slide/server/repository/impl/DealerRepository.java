package cn.org.nf404.slide.server.repository.impl;

import cn.org.nf404.slide.server.domain.model.Dealer;
import cn.org.nf404.slide.server.repository.converter.DealerDoConverter;
import cn.org.nf404.slide.server.repository.dao.DealerDao;
import cn.org.nf404.slide.server.repository.entity.BaseDO;
import cn.org.nf404.slide.server.repository.entity.DealerDO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Repository
@AllArgsConstructor
public class DealerRepository {
    private final DealerDao dealerDao;
    private final DealerDoConverter doConverter;

    public Long save(Dealer toCreate) {
        DealerDO dealerDO = this.doConverter.model2Do(toCreate);
        BaseDO.init(dealerDO);
        DealerDO save = this.dealerDao.save(dealerDO);
        return save.getId();
    }
}
