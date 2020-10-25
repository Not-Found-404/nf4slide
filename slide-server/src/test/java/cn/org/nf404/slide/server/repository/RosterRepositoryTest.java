package cn.org.nf404.slide.server.repository;

import cn.org.nf404.slide.server.BaseTest;
import cn.org.nf404.slide.server.domain.model.Roster;
import cn.org.nf404.slide.server.domain.model.RosterGroup;
import cn.org.nf404.slide.server.repository.impl.RosterRepository;
import com.google.common.collect.Lists;
import com.google.common.hash.Hashing;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author dx DingXing
 * @since 2020-10-25
 */
public class RosterRepositoryTest extends BaseTest {

    @Autowired
    private RosterRepository rosterRepository;

    private String firstId;
    private String secondId;

    @Before
    public void init() {
        List<Roster> first = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            Roster roster = this.random.nextObject(Roster.class);
            roster.getGroup().setGroupName("初一三班");
            roster.getGroup().setGroupId(Hashing.md5().hashBytes(roster.getGroup().getGroupName().getBytes()).toString());
            firstId = roster.getGroup().getGroupId();
            first.add(roster);
        }

        Integer creates = this.rosterRepository.creates(first);
        assert creates.equals(first.size());


        Roster second = this.random.nextObject(Roster.class);
        second.getGroup().setGroupName("初二一班");
        second.getGroup().setGroupId(Hashing.md5().hashBytes(second.getGroup().getGroupName().getBytes()).toString());
        secondId = second.getGroup().getGroupId();

        Roster roster = this.rosterRepository.create(second);
        assert roster != null;
    }

    @Test
    public void findByGroup() {

        List<Roster> firstGroup = this.rosterRepository.findByGroupId(firstId);
        assert firstGroup.size() == 5;
        assert firstGroup.stream().findAny().orElse(null).getGroup().getGroupName().equals("初一三班");


        List<Roster> secondGroup = this.rosterRepository.findByGroupId(secondId);
        assert secondGroup.size() == 1;
        assert secondGroup.stream().findAny().orElse(null).getGroup().getGroupName().equals("初二一班");

    }


    @Test
    public void findGroups() {
        List<RosterGroup> groups = this.rosterRepository.findGroups();
        assert groups.size() == 2;
    }
}
