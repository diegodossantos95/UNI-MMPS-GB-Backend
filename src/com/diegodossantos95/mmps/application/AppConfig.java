package com.diegodossantos95.mmps.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableAsync
@EnableJpaRepositories(basePackages = { "com.diegodossantos95.mmps.repository" })
@EnableWebMvc
@ComponentScan(basePackages = {
		"com.diegodossantos95.mmps.exception",  
		"com.diegodossantos95.mmps.service",
		"com.diegodossantos95.mmps.controller", 
		"com.diegodossantos95.mmps.model",
		"com.diegodossantos95.mmps.rest"
		})
@EnableTransactionManagement
@EnableSpringDataWebSupport
@EnableScheduling
class AppConfig {
}