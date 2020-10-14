package cn.org.nf404.slide.server.repository;

import cn.org.nf404.slide.server.BaseTest;
import cn.org.nf404.slide.server.domain.model.Slide;
import cn.org.nf404.slide.server.repository.impl.SlideRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dx DingXing
 * @since 2020-10-12
 */

public class SlideRepositoryTest extends BaseTest {
    @Autowired
    private SlideRepository slideRepository;

    @Test
    public void init() {
        Slide slide = this.random.nextObject(Slide.class);
        slide = this.slideRepository.create(slide);
        assert slide != null;

        Slide findById = this.slideRepository.findById(slide.getId());
        assert findById != null;
    }
}
