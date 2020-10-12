package cn.org.nf404.slide.server;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import io.github.benas.randombeans.api.Randomizer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Random;

/**
 * @author dx DingXing
 * @since 2020-10-12
 */
@Profile("test")
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class IntegrationTestConfiguration {
    @Bean
    public EnhancedRandom randomBean() {
        return EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .seed(System.currentTimeMillis())
                .collectionSizeRange(1, 3)
                .stringLengthRange(3, 5)
                .randomize(Integer.class,
                        (Randomizer<Integer>) () -> Math.abs(new Random(System.currentTimeMillis()).nextInt(4)))
                .randomize(Long.class,
                        (Randomizer<Long>) () -> Math.abs(new Random(System.currentTimeMillis()).nextLong()) % 10000)
                .build();
    }
}
