package cn.org.nf404.slide.server.domain.converter;

import cn.org.nf404.slide.api.request.goods.GoodsCreateRequest;
import cn.org.nf404.slide.server.domain.model.Goods;
import cn.org.nf404.slide.server.repository.converter.JsonConverter;
import org.mapstruct.Mapper;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Mapper(componentModel = "spring", uses = JsonConverter.class)
public interface GoodsConverter {
    Goods request2Model(GoodsCreateRequest goodsCreateRequest);
}
