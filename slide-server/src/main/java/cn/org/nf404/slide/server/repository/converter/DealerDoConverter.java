package cn.org.nf404.slide.server.repository.converter;

import cn.org.nf404.slide.server.domain.model.Dealer;
import cn.org.nf404.slide.server.repository.entity.DealerDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.persistence.Column;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Mapper(componentModel = "spring", uses = JsonConverter.class)
public interface DealerDoConverter {

    @Mapping(source = "extra", target = "extraJson")
    @Mapping(source = "address.phone", target = "phone")
    @Mapping(source = "address.fullDetailAddress", target = "fullDetailAddress")
    @Mapping(source = "address.detailAddress", target = "detailAddress")
    @Mapping(source = "address.endpointAddressId", target = "endpointAddressId")
    DealerDO model2Do(Dealer toCreate);

    @Mapping(target = "extra", source = "extraJson")
    @Mapping(target = "address.phone", source = "phone")
    @Mapping(target = "address.fullDetailAddress", source = "fullDetailAddress")
    @Mapping(target = "address.detailAddress", source = "detailAddress")
    @Mapping(target = "address.endpointAddressId", source = "endpointAddressId")
    Dealer do2Model(DealerDO toCreate);
}
