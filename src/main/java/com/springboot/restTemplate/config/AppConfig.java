package com.springboot.restTemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


//it act as a configuration class where it contain multiple beans
@Configuration
public class AppConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
