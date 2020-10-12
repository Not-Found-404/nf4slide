package cn.org.nf404.slide.server.domain.service;

import cn.org.nf404.slide.api.request.slide.SlideCreateRequest;
import cn.org.nf404.slide.server.domain.model.Slide;
import cn.org.nf404.slide.server.repository.impl.SlideRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author dx DingXing
 * @since 2020-10-06
 */
@Slf4j
@Service
@AllArgsConstructor
public class SlideWriteService {
    private SlideRepository slideRepository;

    public Slide create(SlideCreateRequest request) {
        return null;
    }
}
