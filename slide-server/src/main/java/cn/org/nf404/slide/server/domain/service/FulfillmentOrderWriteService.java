package cn.org.nf404.slide.server.domain.service;

import cn.org.nf404.slide.api.request.fulfillment.FulfillmentOrderCreateRequest;
import cn.org.nf404.slide.api.request.fulfillment.FulfillmentOrderLineCreateParam;
import cn.org.nf404.slide.common.model.enums.ModelStatusEnum;
import cn.org.nf404.slide.common.model.exception.ServiceException;
import cn.org.nf404.slide.server.domain.converter.FulfillmentOrderConverter;
import cn.org.nf404.slide.server.domain.model.*;
import cn.org.nf404.slide.server.repository.impl.FulfillmentOrderRepository;
import cn.org.nf404.slide.server.repository.impl.GoodsRepository;
import cn.org.nf404.slide.server.repository.impl.UserRepository;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dx DingXing
 * @date 2020-09-30
 */
@Slf4j
@Service
@AllArgsConstructor
public class FulfillmentOrderWriteService {
    private final FulfillmentOrderRepository orderRepository;
    private final FulfillmentOrderConverter orderConverter;

    private final UserRepository userRepository;
    private final GoodsRepository goodsRepository;

    public Long create(FulfillmentOrderCreateRequest request) {
        User acceptor = this.userRepository.findById(request.getAcceptorId());
        if (null == acceptor) {
            throw ServiceException.of("user.not.exist", request.getAcceptorId());
        }

        Set<Long> goodsIds = request.getOrderLineLists().stream()
                .map(FulfillmentOrderLineCreateParam::getGoodsId)
                .collect(Collectors.toSet());
        Map<Long, Goods> idToGoods = this.checkGoods(goodsIds);
        Multimap<Long, FulfillmentOrderLine> historyOrderLine = this.orderRepository.findHistory(request.getDealerId(), idToGoods.keySet());
        ;

        Map<Long, Long> goodsIdToHistoryPrice = historyOrderLine.keySet().stream()
                .map(e -> Lists.newArrayList(historyOrderLine.get(e)).get(0))
                .collect(Collectors.toMap(FulfillmentOrderLine::getGoodsId, e -> e.getPrice().getPaidAmount()));
        Map<Long, Long> goodsIdToOriginalPrice = idToGoods.values().stream()
                .collect(Collectors.toMap(Goods::getId, Goods::getOriginalAmount));

        OperateInfo operateInfo = new OperateInfo();
        operateInfo.setAcceptorId(acceptor.getId());
        operateInfo.setAcceptorName(acceptor.getName());


        List<FulfillmentOrderLine> orderLineList = request.getOrderLineLists().stream()
                .map(e -> {
                    FulfillmentOrderLine orderLine = this.orderConverter.request2Model(e);

                    Long requestPaidAmount = e.getPaidAmount();
                    Long paidAmount = requestPaidAmount;
                    Long originalAmount = goodsIdToOriginalPrice.get(e.getGoodsId());
                    if (null == requestPaidAmount) {
                        Long historyPrice = goodsIdToHistoryPrice.get(e.getGoodsId());
                        paidAmount = null != historyPrice ? historyPrice : originalAmount;
                    }

                    orderLine.setOperateInfo(operateInfo);
                    orderLine.setPrice(Price.of(originalAmount, paidAmount));
                    return orderLine;
                })
                .collect(Collectors.toList());

        FulfillmentOrder order = orderConverter.request2Model(request);

        Long totalOriginalAmount = orderLineList.stream().mapToLong(e -> e.getPrice().getOriginalAmount() * e.getQuantity()).sum();
        Long totalPaidAmount = orderLineList.stream().mapToLong(e -> e.getPrice().getPaidAmount() * e.getQuantity()).sum();
        Price totalPrice = Price.of(totalOriginalAmount, totalPaidAmount);

        OrderStatus initStatus = OrderStatus.init();
        order.setOrderStatus(initStatus);
        order.setPrice(totalPrice);
        order.setOperateInfo(operateInfo);

        return this.orderRepository.create(order);
    }

    private Map<Long, Goods> checkGoods(Set<Long> goodsIds) {
        Map<Long, Goods> idToGoods = this.goodsRepository.findByIds(goodsIds).stream()
                .collect(Collectors.toMap(Goods::getId, e -> e));
        goodsIds.forEach(goodsId -> {
            Goods goods = idToGoods.get(goodsId);
            if (null == goods) {
                throw ServiceException.of("goods.not.exist", goodsId);
            }
            if (ModelStatusEnum.DELETE.equals(goods.getStatus())) {
                throw ServiceException.of("goods.has.delete", goodsId);
            }
        });
        return idToGoods;
    }
}
