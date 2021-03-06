package de.hska.iwi.oauth.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@Order(-20)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/*
	 * Override this method to expose the AuthenticationManager from 
	 * configure(AuthenticationManagerBuilder) to be exposed as a Bean. 
	 * 
	 */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
        	.inMemoryAuthentication()
        		.withUser("user").password("password").roles("USER")
        	.and().withUser("admin").password("admin").roles("ADMIN");

    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//	        .requestMatchers().antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access", "/webjars/**")
//	        .and()
//	       	.formLogin().loginPage("/login").permitAll().failureUrl("/login?error")
//            .and()
//        	.authorizeRequests().anyRequest().authenticated();
        .authorizeRequests()
        	.antMatchers("/oauth/authorize", "/oauth/confirm_access", "/webjars/**").permitAll()
        	.anyRequest().authenticated() 
        	.and()
        .formLogin()
        	.loginPage("/login")
        	.permitAll()
        	.and()
    	.logout()
    		.permitAll();
                
    }
    



}
