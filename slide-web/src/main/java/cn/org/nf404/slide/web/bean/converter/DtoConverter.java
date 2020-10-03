package cn.org.nf404.slide.web.bean.converter;

import cn.org.nf404.slide.api.request.dealer.DealerCreateRequest;
import cn.org.nf404.slide.api.request.dealer.FulfillmentOrderPagingRequest;
import cn.org.nf404.slide.api.request.fulfillment.FulfillmentOrderCreateRequest;
import cn.org.nf404.slide.api.request.fulfillment.FulfillmentOrderDetailRequest;
import cn.org.nf404.slide.api.request.goods.GoodsCreateRequest;
import cn.org.nf404.slide.api.request.user.UserRegistryRequest;
import cn.org.nf404.slide.web.bean.dto.FulfillmentOrderDetailRequestDTO;
import cn.org.nf404.slide.web.bean.dto.FulfillmentOrderPagingRequestDTO;
import cn.org.nf404.slide.web.bean.dto.dealer.DealerCreateRequestDTO;
import cn.org.nf404.slide.web.bean.dto.goods.GoodsCreateRequestDTO;
import cn.org.nf404.slide.web.bean.dto.order.FulfillmentOrderCreateRequestDTO;
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

    DealerCreateRequest toRequest(DealerCreateRequestDTO requestDTO);

    GoodsCreateRequest toRequest(GoodsCreateRequestDTO requestDTO);

    FulfillmentOrderCreateRequest toRequest(FulfillmentOrderCreateRequestDTO requestDTO);

    FulfillmentOrderPagingRequest toRequest(FulfillmentOrderPagingRequestDTO requestDTO);

    FulfillmentOrderDetailRequest toRequest(FulfillmentOrderDetailRequestDTO requestDTO);
}
