package cn.org.nf404.slide.server.domain.converter;

import cn.org.nf404.slide.api.response.order.*;
import cn.org.nf404.slide.server.domain.model.*;
import cn.org.nf404.slide.server.repository.converter.JsonConverter;
import org.mapstruct.Mapper;

/**
 * @author dx DingXing
 * @date 2020-10-02
 */
@Mapper(componentModel = "spring", uses = JsonConverter.class)
public interface InfoConverter {

    GoodsInfo convert(Goods g);

    PriceInfo convert(Price p);

    FulfillmentOrderInfo convert(FulfillmentOrder o);

    FulfillmentOrderLineInfo convert(FulfillmentOrderLine e);

    OperateDescInfo convert(OperateDesc c);

    DealerInfo convert(Dealer r);

    AddressInfo convert(Address a);
}
