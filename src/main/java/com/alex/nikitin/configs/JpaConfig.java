package com.alex.nikitin.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.alex.nikitin.dao")
@EnableTransactionManagement
public class JpaConfig {

}
