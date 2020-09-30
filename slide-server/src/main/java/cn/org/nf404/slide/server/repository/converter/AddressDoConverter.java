package cn.org.nf404.slide.server.repository.converter;

import cn.org.nf404.slide.server.domain.model.AddressTable;
import cn.org.nf404.slide.server.repository.entity.AddressTableDO;
import org.mapstruct.Mapper;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Mapper(componentModel = "spring", uses = JsonConverter.class)
public interface AddressDoConverter {
    AddressTable do2Model(AddressTableDO addressTableDO);

    AddressTableDO model2Do(AddressTable table);
}
