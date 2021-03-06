package com.a2r2.api.rest.security.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "my_rest_api";
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.exceptionHandling().and()
		.anonymous().and()
		.servletApi().and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/user/**").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.PUT, "/user/**").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.POST, "/user").permitAll()
		.antMatchers(HttpMethod.DELETE, "/user/**").hasAnyRole("ADMIN")	
		.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());

//		http.
//		anonymous().disable()
//		.requestMatchers().antMatchers("/user/**")
//		.and().authorizeRequests()
//		.antMatchers("/user/**").access("hasRole('ADMIN')")
//		.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}
	


}