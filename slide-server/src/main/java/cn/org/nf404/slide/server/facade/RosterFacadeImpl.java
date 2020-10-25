package cn.org.nf404.slide.server.facade;

import cn.org.nf404.slide.api.facade.RosterFacade;
import cn.org.nf404.slide.api.request.roster.RosterGroupQueryRequest;
import cn.org.nf404.slide.api.request.roster.RosterQueryRequest;
import cn.org.nf404.slide.api.response.roster.RosterGroupInfo;
import cn.org.nf404.slide.api.response.roster.RosterInfo;
import cn.org.nf404.slide.common.model.request.Response;
import cn.org.nf404.slide.common.utils.FacadeExecutor;
import cn.org.nf404.slide.server.domain.service.RosterReadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dx DingXing
 * @since 2020-10-25
 */
@Service
@AllArgsConstructor
public class RosterFacadeImpl implements RosterFacade {
    private final RosterReadService readService;

    @Override
    public Response<List<RosterInfo>> query(RosterQueryRequest request) {
        return FacadeExecutor.execute(request,this.readService::query);
    }

    @Override
    public Response<List<RosterGroupInfo>> queryGroup(RosterGroupQueryRequest request) {
        return FacadeExecutor.execute(request,this.readService::queryGroup);
    }
}
