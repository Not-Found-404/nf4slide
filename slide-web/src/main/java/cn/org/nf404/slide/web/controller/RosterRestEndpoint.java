package cn.org.nf404.slide.web.controller;

import cn.org.nf404.slide.api.facade.RosterFacade;
import cn.org.nf404.slide.api.request.roster.RosterGroupQueryRequest;
import cn.org.nf404.slide.api.request.roster.RosterQueryRequest;
import cn.org.nf404.slide.api.response.roster.RosterGroupInfo;
import cn.org.nf404.slide.api.response.roster.RosterInfo;
import cn.org.nf404.slide.web.aop.FacadeInvoker;
import cn.org.nf404.slide.web.bean.converter.DtoConverter;
import cn.org.nf404.slide.web.bean.dto.roster.RosterGroupQueryRequestDTO;
import cn.org.nf404.slide.web.bean.dto.roster.RosterQueryRequestDTO;
import cn.org.nf404.slide.web.component.login.RequestContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dx DingXing
 * @since 2020-10-25
 */
@RestController
@AllArgsConstructor
@Api(tags = "花名册服务", value = "花名册服务")
public class RosterRestEndpoint {
    private final RosterFacade rosterFacade;
    private final DtoConverter dtoConverter;

    @GetMapping("/api/roster/query")
    @ApiOperation("查询")
    public List<RosterInfo> query(RosterQueryRequestDTO requestDTO) {
        RosterQueryRequest request = this.dtoConverter.convert(requestDTO);
        return FacadeInvoker.invoke(this.rosterFacade::query, request);
    }

    @GetMapping("/api/roster/group/query")
    @ApiOperation("组查询")
    public List<RosterGroupInfo> queryGroup(RosterGroupQueryRequestDTO requestDTO) {
        RosterGroupQueryRequest request = this.dtoConverter.convert(requestDTO);
        request.setUserId(RequestContext.getUserId());
        return FacadeInvoker.invoke(this.rosterFacade::queryGroup, request);
    }
}
