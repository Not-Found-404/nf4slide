package cn.org.nf404.slide.web.controller;

import cn.org.nf404.slide.api.facade.GoodsFacade;
import cn.org.nf404.slide.api.request.goods.GoodsCreateRequest;
import cn.org.nf404.slide.common.utils.FacadeInvoker;
import cn.org.nf404.slide.web.bean.converter.DtoConverter;
import cn.org.nf404.slide.web.bean.dto.goods.GoodsCreateRequestDTO;
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
public class GoodsRestEndpoint {
    private final DtoConverter dtoConverter;
    private final GoodsFacade goodsFacade;

    @PostMapping("/api/goods/create")
    public Long create(@RequestBody GoodsCreateRequestDTO requestDTO) {
        GoodsCreateRequest request = this.dtoConverter.toRequest(requestDTO);
        return FacadeInvoker.invoke(this.goodsFacade::create, request);
    }
}
