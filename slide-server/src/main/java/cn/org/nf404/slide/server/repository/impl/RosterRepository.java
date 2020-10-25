package cn.org.nf404.slide.server.repository.impl;

import cn.org.nf404.slide.server.domain.model.Roster;
import cn.org.nf404.slide.server.domain.model.RosterGroup;
import cn.org.nf404.slide.server.repository.converter.DoConverter;
import cn.org.nf404.slide.server.repository.dao.RosterDao;
import cn.org.nf404.slide.server.repository.entity.BaseDO;
import cn.org.nf404.slide.server.repository.entity.RosterDO;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dx DingXing
 * @since 2020-10-25
 */
@Repository
@AllArgsConstructor
public class RosterRepository {
    private final RosterDao rosterDao;
    private final DoConverter doConverter;

    public Integer creates(List<Roster> rosters) {
        if (CollectionUtils.isEmpty(rosters)) {
            return 0;
        }
        List<RosterDO> toCreateDos = rosters.stream()
                .map(e -> {
                    RosterDO convert = this.doConverter.convert(e);
                    BaseDO.init(convert);
                    return convert;
                })
                .collect(Collectors.toList());
        List<RosterDO> saveAll = this.rosterDao.saveAll(toCreateDos);
        return (int) saveAll.stream()
                .map(this.doConverter::convert).count();
    }

    public Roster create(Roster roster) {
        RosterDO toCreate = this.doConverter.convert(roster);
        BaseDO.init(toCreate);
        return this.doConverter.convert(this.rosterDao.save(toCreate));
    }

    public Roster update(Roster roster) {
        RosterDO toUpdate = this.doConverter.convert(roster);
        return this.doConverter.convert(this.rosterDao.save(toUpdate));
    }

    public List<Roster> findByGroupId(String groupId) {
        if (Strings.isNullOrEmpty(groupId)) {
            return Lists.newArrayListWithCapacity(0);
        }

        List<RosterDO> rosterDOList = this.rosterDao.findByGroupId(groupId);
        return rosterDOList.stream()
                .map(this.doConverter::convert)
                .collect(Collectors.toList());
    }

    public List<RosterGroup> findGroups() {
        List<RosterDO> rosterDOList = this.rosterDao.findGroups();
        return rosterDOList.stream()
                .map(this.doConverter::convertToGroup)
                .collect(Collectors.toList());
    }
}
