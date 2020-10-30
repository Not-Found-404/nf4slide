package cn.org.nf404.slide.server;

import cn.org.nf404.slide.api.request.slide.SlideCreateRequest;
import cn.org.nf404.slide.api.response.slide.SlideInfo;
import cn.org.nf404.slide.server.domain.service.SlideWriteService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dx DingXing
 * @since 2020-10-30
 */
public class SlideWriteServiceTest extends BaseTest {
    @Autowired
    private SlideWriteService slideWriteService;

    @Test
    public void create() {
        SlideCreateRequest request = new SlideCreateRequest();
        request.setCreatorId(111L);
        request.setFolderId(1L);
        request.setSlideName("");
        SlideInfo slideInfo = this.slideWriteService.create(request);
        assert slideInfo != null;
    }
}
