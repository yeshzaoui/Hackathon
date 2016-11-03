package io.hackathon.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	 @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .csrf().disable()
	      .authorizeRequests()
	        .antMatchers(HttpMethod.POST, "/**").authenticated()
	        .antMatchers(HttpMethod.PUT, "/**").authenticated()
	        .antMatchers(HttpMethod.DELETE, "/**").authenticated()
	        .anyRequest().permitAll()
	        .and()
	      .httpBasic().and()
	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	  }

}
