package cn.org.nf404.slide.server.repository.impl;

import cn.org.nf404.slide.server.domain.model.FulfillmentOrder;
import cn.org.nf404.slide.server.domain.model.FulfillmentOrderLine;
import cn.org.nf404.slide.server.repository.converter.FulfillmentOrderDoConverter;
import cn.org.nf404.slide.server.repository.converter.FulfillmentOrderLineDoConverter;
import cn.org.nf404.slide.server.repository.dao.FulfillmentOrderDao;
import cn.org.nf404.slide.server.repository.dao.FulfillmentOrderLineDao;
import cn.org.nf404.slide.server.repository.entity.FulfillmentOrderDO;
import cn.org.nf404.slide.server.repository.entity.FulfillmentOrderLineDO;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dx DingXing
 * @date 2020-09-30
 */
@Repository
@AllArgsConstructor
public class FulfillmentOrderRepository {
    private final FulfillmentOrderDoConverter orderDoConverter;
    private final FulfillmentOrderLineDoConverter orderLineDoConverter;
    private final FulfillmentOrderDao orderDao;
    private final FulfillmentOrderLineDao orderLineDao;

    @Transactional(rollbackFor = Exception.class)
    public Long create(FulfillmentOrder order) {
        FulfillmentOrderDO toCreateOrderDo = this.orderDoConverter.model2Do(order);

        List<FulfillmentOrderLineDO> orderLineDOList = order.getFulfillmentOrderLines().stream()
                .map(this.orderLineDoConverter::model2Do)
                .collect(Collectors.toList());

        FulfillmentOrderDO saveOrder = this.orderDao.save(toCreateOrderDo);
        orderLineDOList.forEach(e -> e.setFulfillmentOrderId(saveOrder.getId()));
        this.orderLineDao.saveAll(orderLineDOList);
        return saveOrder.getId();
    }

    public Multimap<Long, FulfillmentOrderLine> findHistory(Long dealerId, Collection<Long> goodsIds) {
        Specification<FulfillmentOrderLineDO> specification = Specification.where((Specification<FulfillmentOrderLineDO>) (root, cq, cb) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(cb.equal(root.<Integer>get("dealerId"), dealerId));
            list.add(root.<Long>get("goods").in(goodsIds));
            list.add(cb.isNotNull(root.<Long>get("deliveredAt")));
            return cq.where(list.toArray(new Predicate[0])).getRestriction();
        });

        List<FulfillmentOrderLine> history = this.orderLineDao.findAll(specification, Sort.by("deliveredAt")).stream()
                .map(this.orderLineDoConverter::do2Model)
                .collect(Collectors.toList());

        Multimap<Long, FulfillmentOrderLine> goodsIdToOrderLine = ArrayListMultimap.create();
        history.forEach(e -> goodsIdToOrderLine.put(e.getGoodsId(), e));
        return goodsIdToOrderLine;
    }
}
