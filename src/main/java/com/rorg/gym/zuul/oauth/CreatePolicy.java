package com.rorg.gym.zuul.oauth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

import com.rorg.gym.commons.enums.Role;
import com.rorg.gym.commons.oauth.ApiGatewayEndPoint;
import com.rorg.gym.commons.oauth.ApiGatewayResource;

@Component
public class CreatePolicy implements ICreatePolicy<HttpSecurity, HttpSecurity>, ApiGatewayEndPoint, ApiGatewayResource{

	@Override
	public HttpSecurity createPolicyUserSystem(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers(GYM_SECURITY + ALL_OAUTH).permitAll()
		.anyRequest().hasRole(Role.ROLE_GYM_SYSTEM.getValue());
		return http;
	}
}