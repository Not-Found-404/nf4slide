package cn.org.nf404.slide.web.bean.converter;

import cn.org.nf404.slide.api.request.user.UserRegistryRequest;
import cn.org.nf404.slide.web.bean.dto.user.UserRegisterRequestDTO;
import org.mapstruct.Mapper;


/**
 * @author dx DingXing
 * @date 2020-09-28
 */
@Mapper(componentModel = "spring")
public interface DtoConverter {

    /**
     * dto to request
     *
     * @param dto UserRegisterRequestDTO
     * @return UserRegistryRequest
     */
    UserRegistryRequest toRequest(UserRegisterRequestDTO dto);
}
