package com.digital.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digital.notification.model.*;
import com.digital.notification.service.ApplianceService;

import java.util.*;

@RestController
@RequestMapping("/appliances")
public class AppliancesController {
	
	@Autowired
	ApplianceService applianceService;
	
	
	@PostMapping(value="/connection/status") 
	public List<CustomerApplianceStatus> getApplianceConnectionStatus(){
		// load all appliances status along with customer details
		return applianceService.getApplianceConnectionStatus();
	}
	
	@PostMapping(value="/connection/update")
	public void updateApplianceConnection(@RequestBody ApplianceInfo applianceInfo){
		// update appliance status by fake notification
		applianceService.updateApplianceConnection(applianceInfo);
	}
	

}
