package cn.org.nf404.slide.web.controller;

import cn.org.nf404.slide.api.facade.SlideFacade;
import cn.org.nf404.slide.api.request.slide.SlideCreateRequest;
import cn.org.nf404.slide.api.request.slide.SlideRenderDetailRequest;
import cn.org.nf404.slide.api.request.slide.SlideRenderQueryRequest;
import cn.org.nf404.slide.api.request.slide.SlideUpdateRequest;
import cn.org.nf404.slide.api.response.slide.SlideInfo;
import cn.org.nf404.slide.web.aop.FacadeInvoker;
import cn.org.nf404.slide.web.bean.converter.DtoConverter;
import cn.org.nf404.slide.web.bean.dto.slide.SlideCreateRequestDTO;
import cn.org.nf404.slide.web.bean.dto.slide.SlideRenderDetailRequestDTO;
import cn.org.nf404.slide.web.bean.dto.slide.SlideRenderQueryRequestDTO;
import cn.org.nf404.slide.web.bean.dto.slide.SlideUpdateRequestDTO;
import cn.org.nf404.slide.web.component.login.RequestContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dx DingXing
 * @since 2020-10-14
 */
@RestController
@AllArgsConstructor
@Api(tags = "幻灯片服务", value = "幻灯片服务")
public class SlideRestEndpoint {
    private final SlideFacade slideFacade;
    private final DtoConverter dtoConverter;

    @PostMapping("/api/slide/create")
    @ApiOperation("创建")
    public SlideInfo create(@RequestBody SlideCreateRequestDTO requestDTO) {
        SlideCreateRequest request = this.dtoConverter.convert(requestDTO);
        request.setCreatorId(RequestContext.getUserId());
        return FacadeInvoker.invoke(this.slideFacade::create, request);
    }

    @PostMapping("/api/slide/update")
    @ApiOperation("更新")
    public SlideInfo update(@RequestBody SlideUpdateRequestDTO requestDTO) {
        SlideUpdateRequest request = this.dtoConverter.convert(requestDTO);
        request.setUpdateBy(RequestContext.getUserId());
        return FacadeInvoker.invoke(this.slideFacade::update, request);
    }

    @PostMapping("/api/slide/render/detail")
    @ApiOperation("幻灯片详情")
    public SlideInfo render(SlideRenderDetailRequestDTO requestDTO) {
        SlideRenderDetailRequest request = this.dtoConverter.convert(requestDTO);
        request.setUserId(RequestContext.getUserId());
        return FacadeInvoker.invoke(this.slideFacade::renderDetail, request);
    }


    @PostMapping("/api/slide/render/query")
    @ApiOperation("幻灯片查询")
    public List<SlideInfo> render(SlideRenderQueryRequestDTO requestDTO) {
        SlideRenderQueryRequest request = this.dtoConverter.convert(requestDTO);
        request.setUserId(RequestContext.getUserId());
        return FacadeInvoker.invoke(this.slideFacade::query, request);
    }
}
