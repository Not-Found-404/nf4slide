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
    @Mapping(source = "deliveredAt", target = "operateInfo.deliveredAt")
    @Mapping(source = "acceptorId", target = "operateInfo.acceptorId")
    @Mapping(source = "acceptorName", target = "operateInfo.acceptorName")
    @Mapping(source = "deliveryManId", target = "operateInfo.deliveryManId")
    @Mapping(source = "deliveryManName", target = "operateInfo.deliveryManName")
    @Mapping(source = "paidAt", target = "operateInfo.paidAt")
    // price
    @Mapping(source = "paidAmount", target = "price.paidAmount")
    @Mapping(source = "originalAmount", target = "price.originalAmount")
    FulfillmentOrderLine do2Model(FulfillmentOrderLineDO fulfillmentOrderLineDO);

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
    FulfillmentOrderLineDO model2Do(FulfillmentOrderLine model);
}
