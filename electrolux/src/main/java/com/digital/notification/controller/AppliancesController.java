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
	
	// load all appliances status along with customer details
	@PostMapping(value="/connection/status") 
	public List<CustomerApplianceStatus> getApplianceConnectionStatus(){
		return applianceService.getApplianceConnectionStatus();
	}
	// update appliance status by fake notification
	@PostMapping(value="/connection/update")
	public void updateApplianceConnection(@RequestBody ApplianceInfo applianceInfo){
		applianceService.updateApplianceConnection(applianceInfo);
	}
	

}
