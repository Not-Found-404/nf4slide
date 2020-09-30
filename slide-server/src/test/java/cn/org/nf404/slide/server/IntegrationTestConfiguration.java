package cn.org.nf404.slide.server;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Profile("test")
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class IntegrationTestConfiguration {
}
