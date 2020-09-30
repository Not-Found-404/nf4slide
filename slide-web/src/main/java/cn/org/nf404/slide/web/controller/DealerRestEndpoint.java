package cn.org.nf404.slide.web.controller;

import cn.org.nf404.slide.api.facade.DealerFacade;
import cn.org.nf404.slide.api.request.dealer.DealerCreateRequest;
import cn.org.nf404.slide.common.utils.FacadeInvoker;
import cn.org.nf404.slide.web.bean.converter.DtoConverter;
import cn.org.nf404.slide.web.bean.dto.dealer.DealerCreateRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@RestController
@AllArgsConstructor
public class DealerRestEndpoint {
    private final DealerFacade facade;
    private final DtoConverter converter;

    @PostMapping("/api/dealer/create")
    public Long create(@RequestBody DealerCreateRequestDTO requestDTO) {
        DealerCreateRequest request = this.converter.toRequest(requestDTO);
        return FacadeInvoker.invoke(facade::create, request);
    }
}
