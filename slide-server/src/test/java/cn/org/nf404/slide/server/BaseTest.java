package cn.org.nf404.slide.server;

import io.github.benas.randombeans.api.EnhancedRandom;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author dx DingXing
 * @since 2020-10-12
 */
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = IntegrationTestConfiguration.class)
@Rollback
@Transactional
public abstract class BaseTest {
    @Autowired
    protected EnhancedRandom random;
}
