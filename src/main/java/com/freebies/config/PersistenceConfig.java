package com.freebies.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * 
 * @author Bala
 *
 */
@Configuration
@EnableJpaRepositories(basePackages="com.freebies.dao")
@EntityScan("com.freebies.model")
@EnableTransactionManagement
public class PersistenceConfig {
	
	
}
