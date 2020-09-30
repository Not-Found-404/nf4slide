package cn.org.nf404.slide.server.repository.dao;

import cn.org.nf404.slide.server.IntegrationTestConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = IntegrationTestConfiguration.class)
public class AddressTableDaoTest {

    @Autowired
    private AddressTableDao addressTableDao;

    @Test
    public void notNull() {
        System.out.println(addressTableDao);
    }
}
