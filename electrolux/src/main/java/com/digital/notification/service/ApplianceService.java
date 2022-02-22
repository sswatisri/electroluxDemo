package com.digital.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.digital.notification.model.*;
import com.digital.notification.repository.ApplianceJpaRepository;
import com.digital.notification.repository.CustomerJpaRepository;

import lombok.extern.log4j.Log4j2;

import com.digital.notification.model.ApplianceInfo;
@Service
@Log4j2
public class ApplianceService {
	@Autowired
	ApplianceJpaRepository applianceJpaRepository;
	
	@Autowired
	CustomerJpaRepository customerJpaRepository;
	
	public List<CustomerApplianceStatus> getApplianceConnectionStatus() { // load all appliances connection status along with customer details
		List<CustomerApplianceStatus> customerAppliancesDetails = new ArrayList<CustomerApplianceStatus>();

		List<CustomerDetails> customers = customerJpaRepository.findAll();

		for (CustomerDetails customer : customers) {
			List<ApplianceDetails> applianceStatus = applianceJpaRepository.findByCustomerId(customer.getCustomerId());
			for (ApplianceDetails applianace : applianceStatus) {
				CustomerApplianceStatus custAppStatus = new CustomerApplianceStatus();
				custAppStatus.setAddress(customer.getCustomerAddress());
				custAppStatus.setApplianceId(applianace.getApplianceId());
				custAppStatus.setCustomerName(customer.getCustomerName());
				custAppStatus.setFactoryNumber(applianace.getFactoryNumber());
				custAppStatus.setStatus(applianace.getStatus());
				customerAppliancesDetails.add(custAppStatus);
			}

		}
		return customerAppliancesDetails;
	}

	public void updateApplianceConnection(ApplianceInfo applianceInfo) { // update appliance connection status in data store
		
		applianceJpaRepository.updateConnectionStatus(applianceInfo.getStatus(), applianceInfo.getApplianceId(), applianceInfo.getCustomerId());
		log.info("Appliance {} is now {}",applianceInfo.getApplianceId(),applianceInfo.getStatus());
	}

}
