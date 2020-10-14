package cn.org.nf404.slide.web.bean.converter;

import cn.org.nf404.slide.api.request.slide.SlideCreateRequest;
import cn.org.nf404.slide.api.request.slide.SlideRenderDetailRequest;
import cn.org.nf404.slide.api.request.slide.SlideUpdateRequest;
import cn.org.nf404.slide.api.request.user.UserRegistryRequest;
import cn.org.nf404.slide.web.bean.dto.slide.SlideCreateRequestDTO;
import cn.org.nf404.slide.web.bean.dto.slide.SlideRenderDetailRequestDTO;
import cn.org.nf404.slide.web.bean.dto.slide.SlideUpdateRequestDTO;
import cn.org.nf404.slide.web.bean.dto.user.UserRegisterRequestDTO;
import org.mapstruct.Mapper;


/**
 * @author dx DingXing
 * @since 2020-09-28
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

    /**
     * Dto to request
     *
     * @param requestDTO SlideCreateRequestDTO
     * @return SlideCreateRequest
     */
    SlideCreateRequest convert(SlideCreateRequestDTO requestDTO);

    /**
     * Dto to request
     *
     * @param requestDTO SlideUpdateRequestDTO
     * @return SlideUpdateRequest
     */
    SlideUpdateRequest convert(SlideUpdateRequestDTO requestDTO);

    /**
     * Dto to request
     *
     * @param requestDTO SlideRenderDetailRequestDTO
     * @return SlideRenderDetailRequest
     */
    SlideRenderDetailRequest convert(SlideRenderDetailRequestDTO requestDTO);
}
