package cn.org.nf404.slide.server.domain.service;

import cn.org.nf404.slide.server.repository.impl.RosterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author dx DingXing
 * @since 2020-10-25
 */
@Service
@AllArgsConstructor
public class RosterWriteService {
    private final RosterRepository rosterRepository;


}
