package com.proyect.main.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
	    protected void configure(HttpSecurity http) throws Exception{
		   	http
		   .antMatcher("/**").authorizeRequests()
		   .antMatchers(resources).permitAll() 
		   .antMatchers("/").permitAll()
		   .antMatchers(HttpMethod.GET,"/tareas").authenticated()
		   .antMatchers(HttpMethod.GET,"/*").permitAll()
	       .antMatchers(HttpMethod.POST,"/*").permitAll()
	       .antMatchers(HttpMethod.PUT,"/*").permitAll()
	       .antMatchers(HttpMethod.DELETE,"//*").permitAll()
	       .anyRequest().authenticated()
	       .and()
	       .logout().logoutUrl("/logout").logoutSuccessUrl("/")
	       .and()
	       .oauth2Login().defaultSuccessUrl("/tareas", true)
	       .loginPage("/login").authorizationEndpoint().baseUri("/login/oauth2/authorization")
	       ;
	       
	       
	        http.cors().and().csrf().disable();
	    }
	   
	 
	   
	   

//	 @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http
//	            .authorizeRequests(authorize -> authorize
//	                .anyRequest().authenticated()
//	            )
//	            .oauth2Login(withDefaults());
//	    }
}

