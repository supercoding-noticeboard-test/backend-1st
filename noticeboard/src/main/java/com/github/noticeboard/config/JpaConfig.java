package com.github.noticeboard.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.github.noticeboard.repository.commentLikes"},
        entityManagerFactoryRef = "entityManagerFactoryBean1",
        transactionManagerRef = "tmJpa1"
)
public class JpaConfig {

    @Bean
    public javax.sql.DataSource dataSource1() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("wlsus2847!!");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/noticeboard?useUnicode=true&characterEncoding=UTF-8");
        return dataSource;

    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean1(@Qualifier("dataSource1")DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.github.noticeboard.repository.commentLikes");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.use_sql_comment", "true");

        em.setJpaPropertyMap(properties);

        return em;

    }

    @Bean(name = "tmJpa1")
    public PlatformTransactionManager transactionManager1(@Qualifier("dataSource1") DataSource dataSource) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean1(dataSource).getObject());
        return transactionManager;
    }

}
