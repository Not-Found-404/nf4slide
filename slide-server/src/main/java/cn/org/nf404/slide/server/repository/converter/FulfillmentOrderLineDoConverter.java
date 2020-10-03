package cn.org.nf404.slide.server.repository.converter;

import cn.org.nf404.slide.server.domain.model.FulfillmentOrderLine;
import cn.org.nf404.slide.server.repository.entity.FulfillmentOrderLineDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Mapper(componentModel = "spring", uses = JsonConverter.class)
public interface FulfillmentOrderLineDoConverter {
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
    FulfillmentOrderLine do2Model(FulfillmentOrderLineDO fulfillmentOrderLineDO);

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
    FulfillmentOrderLineDO model2Do(FulfillmentOrderLine model);
}
