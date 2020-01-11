package cn.org.nf404.slide.web;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dx DingXing
 * @date 2020-01-03
 */
@Slf4j
@SpringBootApplication
public class SlideWebApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(SlideWebApplication.class, args);
        } catch (Exception e) {
            log.error("slide web application start failed, cause:{}", Throwables.getStackTraceAsString(e));
            throw e;
        }
    }
}
