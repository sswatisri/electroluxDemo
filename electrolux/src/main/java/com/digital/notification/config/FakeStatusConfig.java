package com.digital.notification.config;

import java.util.concurrent.LinkedBlockingDeque;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.digital.notification.model.ApplianceInfo;

@Configuration
public class FakeStatusConfig {
	
	@Bean
	@Qualifier("appliancesStatusObject")
	public LinkedBlockingDeque<ApplianceInfo> getappliancesStatusObject(){
		return new LinkedBlockingDeque<>();
	}
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
