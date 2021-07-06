package me.huypc.springsecurity.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "me.huypc.springsecurity")
//Đọc file properties
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {
	
	//Thêm đối tượng Environment để đọc file .properties
	@Autowired
	private Environment env;
	
	//thêm cả logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//Phải có ViewResolver để render ra view
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		//url: /WEB-INF/view/<tên trang>.jsp
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	//khai báo bean cho datasource
	@Bean
	public DataSource getDataSource() {
		
		//Tạo connection pool
		ComboPooledDataSource ds = new ComboPooledDataSource();
		
		//set jdbc driver class
		try {
			ds.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		//log connection properties
		logger.info(">>>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>>> jdbc.user=" + env.getProperty("jdbc.user"));
		
		//set database connection properties
		ds.setJdbcUrl(env.getProperty("jdbc.url"));
		ds.setUser(env.getProperty("jdbc.user"));
		ds.setPassword(env.getProperty("jdbc.password"));
		
		//set connection pool properties
		ds.setInitialPoolSize(
				getIntProperty(env.getProperty("connection.pool.initialPoolSize"))
				);
		ds.setMinPoolSize(
				getIntProperty(env.getProperty("connection.pool.minPoolSize"))
				);
		ds.setMaxPoolSize(
				getIntProperty(env.getProperty("connection.pool.maxPoolSize"))
				);
		ds.setMaxIdleTime(
				getIntProperty(env.getProperty("connection.pool.maxIdleTime"))
				);
		
		
		return ds;
	}
	
	private int getIntProperty(String value) {
		int result = Integer.parseInt(value);
		return result;
	}
	
}
