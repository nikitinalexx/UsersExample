package com.alex.nikitin.configs;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = {"com.alex.nikitin.dao"})
@EnableTransactionManagement
public class HibernateConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

        final LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setPersistenceProvider(new HibernatePersistenceProvider());
        bean.setDataSource(dataSource);
        bean.setPackagesToScan("com.alex.nikitin.model");

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.ddl-auto", "update");
        jpaProperties.put("hibernate.show_sql", true);
        jpaProperties.put("hibernate.format_sql", true);

        bean.setJpaProperties(jpaProperties);

        return bean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(entityManagerFactory.unwrap(SessionFactory.class));
        return transactionManager;
    }

}
