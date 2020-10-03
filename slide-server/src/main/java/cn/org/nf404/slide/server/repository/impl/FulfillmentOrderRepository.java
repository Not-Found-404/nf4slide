package cn.org.nf404.slide.server.repository.impl;

import cn.org.nf404.slide.server.domain.model.Dealer;
import cn.org.nf404.slide.server.domain.model.FulfillmentOrder;
import cn.org.nf404.slide.server.domain.model.FulfillmentOrderLine;
import cn.org.nf404.slide.server.domain.model.Goods;
import cn.org.nf404.slide.server.repository.converter.DealerDoConverter;
import cn.org.nf404.slide.server.repository.converter.FulfillmentOrderDoConverter;
import cn.org.nf404.slide.server.repository.converter.FulfillmentOrderLineDoConverter;
import cn.org.nf404.slide.server.repository.converter.GoodsDoConverter;
import cn.org.nf404.slide.server.repository.dao.DealerDao;
import cn.org.nf404.slide.server.repository.dao.FulfillmentOrderDao;
import cn.org.nf404.slide.server.repository.dao.FulfillmentOrderLineDao;
import cn.org.nf404.slide.server.repository.dao.GoodsDao;
import cn.org.nf404.slide.server.repository.entity.BaseDO;
import cn.org.nf404.slide.server.repository.entity.FulfillmentOrderDO;
import cn.org.nf404.slide.server.repository.entity.FulfillmentOrderLineDO;
import cn.org.nf404.slide.server.repository.entity.GoodsDO;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dx DingXing
 * @date 2020-09-30
 */
@Repository
@AllArgsConstructor
@SuppressWarnings("Duplicates")
public class FulfillmentOrderRepository {
    private final FulfillmentOrderDoConverter orderDoConverter;
    private final FulfillmentOrderLineDoConverter orderLineDoConverter;
    private final DealerDoConverter dealerDoConverter;
    private final GoodsDoConverter goodsDoConverter;
    private final GoodsDao goodsDao;
    private final DealerDao dealerDao;
    private final FulfillmentOrderDao orderDao;
    private final FulfillmentOrderLineDao orderLineDao;

    @Transactional(rollbackFor = Exception.class)
    public Long create(FulfillmentOrder order) {
        FulfillmentOrderDO toCreateOrderDo = this.orderDoConverter.model2Do(order);
        BaseDO.init(toCreateOrderDo);

        List<FulfillmentOrderLineDO> orderLineDOList = order.getFulfillmentOrderLines().stream()
                .map(this.orderLineDoConverter::model2Do)
                .collect(Collectors.toList());

        FulfillmentOrderDO saveOrder = this.orderDao.save(toCreateOrderDo);
        orderLineDOList.forEach(e -> {
            e.setFulfillmentOrderId(saveOrder.getId());
            BaseDO.init(e);
        });
        this.orderLineDao.saveAll(orderLineDOList);
        return saveOrder.getId();
    }

    public Multimap<Long, FulfillmentOrderLine> findHistory(Long dealerId, Collection<Long> goodsIds) {
        Specification<FulfillmentOrderLineDO> specification = Specification.where((Specification<FulfillmentOrderLineDO>) (root, cq, cb) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(cb.equal(root.<Integer>get("dealerId"), dealerId));
            list.add(root.<Long>get("goodsId").in(goodsIds));
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

    public FulfillmentOrder findById(Long fulfillmentOrderId) {
        if (null == fulfillmentOrderId) {
            return null;
        }

        Optional<FulfillmentOrderDO> optionalFulfillmentOrderDO = this.orderDao.findById(fulfillmentOrderId);
        FulfillmentOrder order = this.orderDoConverter.do2Model(optionalFulfillmentOrderDO.orElse(null));
        if (null == order) {
            return null;
        }

        Dealer dealer = this.dealerDoConverter.do2Model(this.dealerDao.findById(order.getDealerId()).orElse(null));
        order.setDealer(dealer);

        List<FulfillmentOrderLine> orderLines = this.orderLineDao.findByFulfillmentOrderId(fulfillmentOrderId).stream()
                .map(this.orderLineDoConverter::do2Model)
                .collect(Collectors.toList());

        List<Long> goodsIds = orderLines.stream().map(FulfillmentOrderLine::getGoodsId).collect(Collectors.toList());
        Specification<GoodsDO> specification = Specification.where((Specification<GoodsDO>) (root, cq, cb) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(root.<Long>get("id").in(goodsIds));
            return cq.where(list.toArray(new Predicate[0])).getRestriction();
        });
        Map<Long, Goods> idToGoods = this.goodsDao.findAll(specification).stream()
                .map(this.goodsDoConverter::do2Model)
                .collect(Collectors.toMap(Goods::getId, e -> e));
        orderLines.forEach(e -> e.setGoods(idToGoods.get(e.getGoodsId())));
        order.setFulfillmentOrderLines(orderLines);
        return order;
    }
}
