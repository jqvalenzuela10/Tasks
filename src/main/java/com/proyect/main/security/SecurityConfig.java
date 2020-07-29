package com.proyect.main.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	 String[] resources = new String[]{
	            "/include/**","/estilos/**","/icons/**","/img/**","/js/**","/layer/**"
	    };
	@Override
	public void configure(HttpSecurity httpsecurity) throws Exception {
		httpsecurity
		.antMatcher("/**").authorizeRequests()
		.antMatchers(resources).permitAll() 
		.antMatchers("/").permitAll()
		.anyRequest().authenticated()
		.and()
		.oauth2Login();
	}
}
