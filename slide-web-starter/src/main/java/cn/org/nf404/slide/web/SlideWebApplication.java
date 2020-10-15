package cn.org.nf404.slide.web;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dx DingXing
 * @since 2020-01-03
 */
@Slf4j
@SpringBootApplication
@EnableMethodCache(basePackages = "cn.org.nf404.slide.server.repository")
@EnableCreateCacheAnnotation
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
