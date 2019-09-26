package com.banking.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
		
		@Autowired
	    private DataSource dataSource;
		
		@Override
	    protected void configure(HttpSecurity http) throws Exception {
/*	        http.authorizeRequests()
	                .antMatchers("/", "/home", "/dashboard").permitAll()
	                .anyRequest().authenticated()
	                .and()
	            .logout()
	                .permitAll();*/
	    	http.authorizeRequests().anyRequest().authenticated()
	    	.and().logout().permitAll()
	    	.and().httpBasic().and().csrf().disable();
	    }
		
		@Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	    {
	        auth.jdbcAuthentication().dataSource(dataSource)
	            .authoritiesByUsernameQuery("select username, role from customer where username=?")
	            .usersByUsernameQuery("select username, password, 1 as enabled  from customer where username=?");
	    }
		
		@Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
		
		/*
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			//auth.jdbcAuthentication().dataSource(dataSource);
			//auth.inMemoryAuthentication().withUser("myuser").password("password").roles("USER");
			//auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		}
		*/
		/*@Bean
	    @Override
	    public UserDetailsService userDetailsService() {
	        UserDetails user =
	             User.withDefaultPasswordEncoder()
	                .username("myuser").password("password").roles("USER")
	                .username("nihar").password("password").roles("USER")
	                .username("sachin").password("cricket").roles("USER")
	                .username("admin").password("admin").roles("ADMIN")
	                .build();

	        return new InMemoryUserDetailsManager(user);
	    }
*/
}
