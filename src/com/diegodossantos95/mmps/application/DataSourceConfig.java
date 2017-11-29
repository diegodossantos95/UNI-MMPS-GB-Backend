package com.diegodossantos95.mmps.application;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	@Bean
	public DataSource dataSource() throws NamingException {
		InitialContext ctx = new InitialContext();
		DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/DefaultDB");

		return dataSource;
	}
}
