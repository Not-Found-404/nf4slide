package cn.org.nf404.slide.api.facade;

import cn.org.nf404.slide.api.request.roster.RosterGroupQueryRequest;
import cn.org.nf404.slide.api.request.roster.RosterQueryRequest;
import cn.org.nf404.slide.api.response.roster.RosterGroupInfo;
import cn.org.nf404.slide.api.response.roster.RosterInfo;
import cn.org.nf404.slide.common.model.request.Response;

import java.util.List;

/**
 * @author dx DingXing
 * @since 2020-10-25
 */
public interface RosterFacade {
    /**
     * Query roster by condition
     *
     * @param request condition
     * @return List of roster info
     */
    Response<List<RosterInfo>> query(RosterQueryRequest request);

    /**
     * Query groups
     *
     * @param request RosterGroupQueryRequest
     * @return <List<RosterGroupInfo>
     */
    Response<List<RosterGroupInfo>> queryGroup(RosterGroupQueryRequest request);
}
