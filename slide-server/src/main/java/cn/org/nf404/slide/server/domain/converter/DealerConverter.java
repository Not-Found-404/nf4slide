package cn.org.nf404.slide.server.domain.converter;

import cn.org.nf404.slide.api.request.dealer.DealerCreateRequest;
import cn.org.nf404.slide.server.domain.model.Dealer;
import cn.org.nf404.slide.server.repository.converter.JsonConverter;
import org.mapstruct.Mapper;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Mapper(componentModel = "spring", uses = JsonConverter.class)
public interface DealerConverter {

    Dealer request2Model(DealerCreateRequest request);
}
