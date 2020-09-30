package cn.org.nf404.slide.server.domain.converter;

import cn.org.nf404.slide.api.request.fulfillment.FulfillmentOrderCreateRequest;
import cn.org.nf404.slide.api.request.fulfillment.FulfillmentOrderLineCreateParam;
import cn.org.nf404.slide.server.domain.model.FulfillmentOrder;
import cn.org.nf404.slide.server.domain.model.FulfillmentOrderLine;
import cn.org.nf404.slide.server.repository.converter.JsonConverter;
import org.mapstruct.Mapper;

/**
 * @author dx DingXing
 * @date 2020-09-30
 */
@Mapper(componentModel = "spring", uses = JsonConverter.class)
public interface FulfillmentOrderConverter {
    FulfillmentOrder request2Model(FulfillmentOrderCreateRequest request);

    FulfillmentOrderLine request2Model(FulfillmentOrderLineCreateParam request);
}
