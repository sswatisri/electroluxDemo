package com.digital.notification.controller;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.notification.model.ApplianceInfo;

@RestController
@RequestMapping("/appliances")
public class FakeStatusGeneratorController {
	
	@Autowired
	@Qualifier("appliancesStatusObject")
	LinkedBlockingDeque<ApplianceInfo> appliancesStatusObject;

	@PostMapping(value="/connection/fakenotification")
	public void sendFakeNotification(@RequestBody ApplianceInfo applianceInfo){
		// We don't have real appliances.So, This controller will generate fake notifications for appliances and put it on blocking queue. 
		//Blocking queue will send fake connection  status  of each appliance in every one minute to rest controller http://localhost:8080/appliences/connection/update
		appliancesStatusObject.add(applianceInfo);
	}
}
