package cn.org.nf404.slide.server.domain.service;

import cn.org.nf404.slide.api.request.roster.RosterGroupQueryRequest;
import cn.org.nf404.slide.api.request.roster.RosterQueryRequest;
import cn.org.nf404.slide.api.response.roster.RosterGroupInfo;
import cn.org.nf404.slide.api.response.roster.RosterInfo;
import cn.org.nf404.slide.server.domain.converter.RequestConverter;
import cn.org.nf404.slide.server.domain.model.Roster;
import cn.org.nf404.slide.server.domain.model.RosterGroup;
import cn.org.nf404.slide.server.repository.impl.RosterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dx DingXing
 * @since 2020-10-25
 */
@Service
@AllArgsConstructor
public class RosterReadService {
    private final RosterRepository rosterRepository;
    private final RequestConverter converter;

    public List<RosterInfo> query(RosterQueryRequest request) {
        List<Roster> rosters = this.rosterRepository.findByGroupId(request.getGroupId());
        return rosters.stream()
                .map(this.converter::convert)
                .collect(Collectors.toList());
    }

    public List<RosterGroupInfo> queryGroup(RosterGroupQueryRequest request) {
        request.checkParam();
        List<RosterGroup> groups = this.rosterRepository.findGroups();
        return groups.stream()
                .map(this.converter::convert)
                .collect(Collectors.toList());
    }
}
