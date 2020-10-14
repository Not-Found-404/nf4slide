package cn.org.nf404.slide.web;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
import java.util.Properties;

/**
 * @author dx DingXing
 * @since 2020-01-03
 */
@Configuration
@ComponentScan
@EnableWebMvc
public class SliderWebConfiguration {

    @Bean
    public MessageSource messageSource(
            @Value("${portal.messages.classpath:classpath:messages/messages}") String messagesClasspath) {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        for (String classpath : Lists.newArrayList(messagesClasspath.split(","))) {
            messageSource.addBasenames(classpath);
        }
        Properties p = new Properties();
        p.setProperty("server.error", "系统异常");
        messageSource.setCommonMessages(p);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.CHINA);
        return slr;
    }
}
