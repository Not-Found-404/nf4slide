package cn.org.nf404.slide.server.repository.converter;

import cn.org.nf404.slide.server.domain.model.FulfillmentOrder;
import cn.org.nf404.slide.server.repository.entity.FulfillmentOrderDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Mapper(componentModel = "spring", uses = JsonConverter.class)
public interface FulfillmentOrderDoConverter {

    /**
     * do to model
     *
     * @param fulfillmentOrderDO fulfillmentOrderDO
     * @return User
     */
    @Mapping(target = "extra", source = "extraJson")
    // operate
    @Mapping(source = "deliveredAt", target = "operateInfo.deliveredAt")
    @Mapping(source = "acceptorId", target = "operateInfo.acceptorId")
    @Mapping(source = "acceptorName", target = "operateInfo.acceptorName")
    @Mapping(source = "deliveryManId", target = "operateInfo.deliveryManId")
    @Mapping(source = "deliveryManName", target = "operateInfo.deliveryManName")
    @Mapping(source = "paidAt", target = "operateInfo.paidAt")
    // price
    @Mapping(source = "paidAmount", target = "price.paidAmount")
    @Mapping(source = "originalAmount", target = "price.originalAmount")
    // status
    @Mapping(source = "payStatus", target = "orderStatus.payStatus")
    @Mapping(source = "deliveryStatus", target = "orderStatus.deliveryStatus")
    FulfillmentOrder do2Model(FulfillmentOrderDO fulfillmentOrderDO);

    @Mapping(source = "extra", target = "extraJson")
    // operateInfo
    @Mapping(target = "deliveredAt", source = "operateInfo.deliveredAt")
    @Mapping(target = "acceptorId", source = "operateInfo.acceptorId")
    @Mapping(target = "acceptorName", source = "operateInfo.acceptorName")
    @Mapping(target = "deliveryManId", source = "operateInfo.deliveryManId")
    @Mapping(target = "deliveryManName", source = "operateInfo.deliveryManName")
    @Mapping(target = "paidAt", source = "operateInfo.paidAt")
    // price
    @Mapping(target = "paidAmount", source = "price.paidAmount")
    @Mapping(target = "originalAmount", source = "price.originalAmount")
    // status
    @Mapping(target = "payStatus", source = "orderStatus.payStatus")
    @Mapping(target = "deliveryStatus", source = "orderStatus.deliveryStatus")
    FulfillmentOrderDO model2Do(FulfillmentOrder fulfillmentOrder);
}
