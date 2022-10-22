package com.esprit.gateway.zuulserver.communication;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
	
	public BasicAuthRequestInterceptor mBasicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("user", "password");
	}
}
