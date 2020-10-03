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
    @Mapping(source = "deliveredAt", target = "operateDesc.deliveredAt")
    @Mapping(source = "acceptorId", target = "operateDesc.acceptorId")
    @Mapping(source = "acceptorName", target = "operateDesc.acceptorName")
    @Mapping(source = "deliveryManId", target = "operateDesc.deliveryManId")
    @Mapping(source = "deliveryManName", target = "operateDesc.deliveryManName")
    @Mapping(source = "paidAt", target = "operateDesc.paidAt")
    // price
    @Mapping(source = "paidAmount", target = "price.paidAmount")
    @Mapping(source = "originalAmount", target = "price.originalAmount")
    // status
    @Mapping(source = "payStatus", target = "orderStatus.payStatus")
    @Mapping(source = "deliveryStatus", target = "orderStatus.deliveryStatus")
    FulfillmentOrder do2Model(FulfillmentOrderDO fulfillmentOrderDO);

    @Mapping(source = "extra", target = "extraJson")
    // operateDesc
    @Mapping(target = "deliveredAt", source = "operateDesc.deliveredAt")
    @Mapping(target = "acceptorId", source = "operateDesc.acceptorId")
    @Mapping(target = "acceptorName", source = "operateDesc.acceptorName")
    @Mapping(target = "deliveryManId", source = "operateDesc.deliveryManId")
    @Mapping(target = "deliveryManName", source = "operateDesc.deliveryManName")
    @Mapping(target = "paidAt", source = "operateDesc.paidAt")
    // price
    @Mapping(target = "paidAmount", source = "price.paidAmount")
    @Mapping(target = "originalAmount", source = "price.originalAmount")
    // status
    @Mapping(target = "payStatus", source = "orderStatus.payStatus")
    @Mapping(target = "deliveryStatus", source = "orderStatus.deliveryStatus")
    FulfillmentOrderDO model2Do(FulfillmentOrder fulfillmentOrder);
}
