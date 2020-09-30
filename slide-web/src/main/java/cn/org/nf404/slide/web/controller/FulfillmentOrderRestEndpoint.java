package cn.org.nf404.slide.web.controller;

import cn.org.nf404.slide.api.facade.FulfillmentOrderFacade;
import cn.org.nf404.slide.api.request.fulfillment.FulfillmentOrderCreateRequest;
import cn.org.nf404.slide.common.utils.FacadeInvoker;
import cn.org.nf404.slide.web.bean.converter.DtoConverter;
import cn.org.nf404.slide.web.bean.dto.order.FulfillmentOrderCreateRequestDTO;
import cn.org.nf404.slide.web.component.login.RequestContext;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dx DingXing
 * @date 2020-09-30
 */
@RestController
@AllArgsConstructor
public class FulfillmentOrderRestEndpoint {
    private final FulfillmentOrderFacade orderFacade;
    private final DtoConverter converter;

    @PostMapping("/api/order/create")
    public Long create(@RequestBody FulfillmentOrderCreateRequestDTO requestDTO) {
        FulfillmentOrderCreateRequest request = this.converter.toRequest(requestDTO);
        request.setAcceptorId(RequestContext.getUserId());
        return FacadeInvoker.invoke(this.orderFacade::create, request);
    }
}
