	package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	

	@Bean
	public BCryptPasswordEncoder bcryptedEncode() {
		return new BCryptPasswordEncoder();
	} 
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private JwtRequestFilter jwtRequest;
	
	
	@CrossOrigin
	@Override
	protected void configure( HttpSecurity http ) throws Exception {		
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/users", "/login").permitAll()
		.antMatchers(HttpMethod.GET, "/products","/categories").permitAll()
		.antMatchers(HttpMethod.POST, "/products", "/categories").permitAll()
		.anyRequest().authenticated()
		.and().cors() 
		.and().exceptionHandling()
		.authenticationEntryPoint(jwtAuthenticationEntryPoint)
		.and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequest, UsernamePasswordAuthenticationFilter.class);
		
	}
	
}













