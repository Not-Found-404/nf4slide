package cn.org.nf404.slide.server.repository.jpa;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author dx DingXing
 * @since 2020-09-28
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "masterEntityManagerFactory",//配置连接工厂 entityManagerFactory
        transactionManagerRef = "masterTransactionManager", //配置 事物管理器  transactionManager
        basePackages = {"cn.org.nf404.slide.server.repository.dao"}
)
@AllArgsConstructor
public class MasterDataSourceConfig {
    private final JpaProperties jpaProperties;

    @Bean("masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "master.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("masterEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            EntityManagerFactoryBuilder builder, @Qualifier("masterDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .properties(jpaProperties.getProperties())
                .packages("cn.org.nf404.slide.server.repository.entity")
                .persistenceUnit("masterPersistenceUnit")
                .build();
    }

    @Bean("masterTransactionManager")
    @Primary
    public PlatformTransactionManager transactionManager(
            @Qualifier("masterEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean(name = "masterJdbcTemplate")
    public JdbcTemplate masterJdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
