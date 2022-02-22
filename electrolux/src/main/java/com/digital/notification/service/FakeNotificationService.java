package com.digital.notification.service;


import java.util.Arrays;
import java.util.concurrent.LinkedBlockingDeque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.digital.notification.model.ApplianceInfo;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class FakeNotificationService {
	
	@Autowired
	@Qualifier("appliancesStatusObject")
	LinkedBlockingDeque<ApplianceInfo> appliancesStatusObject;
	
	@Autowired
	RestTemplate restTemplate;

	@Scheduled(fixedRate = 60000) // every one minute appliance fake status will send to  rest controller to update the connection status of appliance in data store 
	public void generateFakeNotifications() {
		log.info("Notification Triggered from fake notifictaion system");
		log.info("No of appliance connection status received: {}",appliancesStatusObject.size());
			while(appliancesStatusObject.size()!=0) { 	
				ApplianceInfo applianceInfo = appliancesStatusObject.poll();
				log.info("Fake Appliance notification polled");
				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				HttpEntity<ApplianceInfo> applianceStatus = new HttpEntity<>(applianceInfo, headers);
				try {
					restTemplate.exchange("http://localhost:8080/appliances/connection/update", HttpMethod.POST,
							applianceStatus, Void.class);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				log.info("Appliance Status Updated!!!");
			}		
		
	}

}
