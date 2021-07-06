package me.huypc.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//Tiêm datasource vào đây
	@Autowired
	private DataSource datasource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Thêm user của mình khi khởi động chạy ứng dụng
		//code cứng
//		UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//		
//		auth.inMemoryAuthentication()
//			.withUser(userBuilder.username("huy").password("123").roles("ADMIN", "EMPLOYEE"))
//			.withUser(userBuilder.username("zaan").password("123").roles("EMPLOYEE", "MANAGER"))
//			.withUser(userBuilder.username("susan").password("123").roles("EMPLOYEE"));
		
		//Lấy dữ liệu từ datasource
		auth.jdbcAuthentication().dataSource(datasource);
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//Dưới dây được gọi là expression, khác với C#, java sử dụng method như các câu điều kiện
		http.authorizeRequests() //hạn chế truy cập dựa trên đối tượng HttpServletRequest
				.antMatchers("/").hasRole("EMPLOYEE") //trang chính cho những user có Role là EMPLOYEE
				.antMatchers("/leaders/**") //link bắt đầu bằng /leaders và tất cả các link con
					.hasRole("MANAGER") //role manager mới truy cập được link /leader/**
				.antMatchers("/systems/**").hasRole("ADMIN") //role admin mới truy cập được /systems/**
			.and()
			.formLogin() //custom lại login form
				.loginPage("/showLoginForm") //show trang login
				.loginProcessingUrl("/authenticateUser") //method controller xử lí POST
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling()
				.accessDeniedPage("/access-denied");
	}
	
}