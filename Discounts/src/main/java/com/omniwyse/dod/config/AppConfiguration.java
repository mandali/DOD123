package com.omni.dod.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.omni.dod.*")
@ImportResource({
	  "/WEB-INF/spring-config.xml"
	})
@EnableTransactionManagement
public class AppConfiguration {
	private static final Logger logger = Logger.getLogger(AppConfiguration.class);

	public AppConfiguration() {
		logger.info("AppConfiguration loading..");

	}

}