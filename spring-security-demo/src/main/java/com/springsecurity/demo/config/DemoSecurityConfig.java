package com.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("Test123").roles("EMPLOYEE"))
			.withUser(users.username("susan").password("Test123").roles("EMPLOYEE","MANAGER"))
			.withUser(users.username("krieg").password("Test123").roles("EMPLOYEE","ADMIN"));
		*/
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
						/* .anyRequest().authenticated() */
						.antMatchers("/").hasRole("EMPLOYEE")
						.antMatchers("/leader").hasRole("MANAGER")
						.antMatchers("/system").hasRole("ADMIN")
						.and()
						.formLogin()
						.loginPage("/showMyLoginPage")
						.loginProcessingUrl("/authenticateTheUser")
						.permitAll()
						.and()
						.logout()
						.permitAll()
						.and()
						.exceptionHandling()
						.accessDeniedPage("/access-denied");
		
	}
	
	
}
