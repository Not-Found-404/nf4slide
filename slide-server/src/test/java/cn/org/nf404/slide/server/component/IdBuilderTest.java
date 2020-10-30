package cn.org.nf404.slide.server.component;

import cn.org.nf404.slide.server.BaseTest;
import cn.org.nf404.slide.server.component.sequence.IdBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dx DingXing
 * @since 2020-10-30
 */
public class IdBuilderTest extends BaseTest {
    @Autowired
    private IdBuilder idBuilder;

    @Test
    public void getId() {
        Long nextId = idBuilder.nextId(BaseTest.class, 1000L);
        assert null != nextId;
    }
}
