package cn.org.nf404.slide.server.repository.converter;

import cn.org.nf404.slide.server.domain.model.Goods;
import cn.org.nf404.slide.server.repository.entity.GoodsDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Mapper(componentModel = "spring", uses = JsonConverter.class)
public interface GoodsDoConverter {
    @Mapping(source = "extra", target = "extraJson")
    GoodsDO model2Do(Goods goodsDO);

    @Mapping(target = "extra", source = "extraJson")
    Goods do2Model(GoodsDO goodsDO);
}
