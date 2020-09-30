package cn.org.nf404.slide.server.domain.service;

import cn.org.nf404.slide.server.domain.model.AddressTable;
import cn.org.nf404.slide.server.repository.impl.AddressTableRepository;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Slf4j
@Service
@AllArgsConstructor
public class AddressReadService {
    private final AddressTableRepository addressTableRepository;

    /**
     * 贵州
     */
    private final Long DEFAULT_PID = 520000L;

    public AddressTable findFullById(Long id) {

        AddressTable byId = addressTableRepository.findById(id);
        this.fillChild(byId);
        return byId;

    }


    private Set<AddressTable> fillChild(AddressTable table) {
        Set<AddressTable> all = Sets.newHashSet();
        all.add(table);
        if (table.getLevel() == 4) {
            return Sets.newHashSet();
        }

        List<AddressTable> byPid = this.addressTableRepository.findByPid(table.getId());
        if (CollectionUtils.isEmpty(byPid)) {
            return Sets.newHashSet();
        }

        table.setChild(byPid);
        byPid.forEach(e -> all.addAll(this.fillChild(e)));
        return all;
    }
}
