package com.omniwyse.dod.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.omniwyse.dod.*")
@ImportResource({
	  "/WEB-INF/spring-config.xml"
	})
@EnableTransactionManagement
public class AppConfiguration {
	private static final Logger LOGGER = Logger.getLogger(AppConfiguration.class);

	public AppConfiguration() {
		LOGGER.info("AppConfiguration loading..");

	}

}