package com.satya.springbootdaoweb;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = { "classpath:application.properties" })
public class ApplicationConfig {
	@Autowired
	Environment environment;

	@Bean
	public DataSource datasource() throws PropertyVetoException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("spring.database.driverClassName"));
		dataSource.setUrl(environment.getProperty("spring.database.url"));
		dataSource.setUsername(environment.getProperty("spring.database.user"));
		dataSource.setPassword(environment.getProperty("spring.database.password"));
		return dataSource;
	}

}
