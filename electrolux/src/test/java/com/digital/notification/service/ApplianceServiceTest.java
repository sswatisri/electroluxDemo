package com.digital.notification.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.digital.notification.model.ApplianceDetails;
import com.digital.notification.model.ApplianceInfo;
import com.digital.notification.model.CustomerDetails;
import com.digital.notification.repository.ApplianceJpaRepository;
import com.digital.notification.repository.CustomerJpaRepository;

@ExtendWith(MockitoExtension.class)
public class ApplianceServiceTest {
	@InjectMocks
	ApplianceService applianceService;
	
	private CustomerJpaRepository customerJpaRepository = Mockito.mock(CustomerJpaRepository.class);
	private ApplianceJpaRepository applianceJpaRepository = Mockito.mock(ApplianceJpaRepository.class);
	private ApplianceInfo applianceInfo = Mockito.mock(ApplianceInfo.class);
	
	@Test
	public void testGetApplianceConnectionStatus() {
		List<CustomerDetails> customersMockList = new ArrayList<>();
		CustomerDetails customerDetails = Mockito.mock(CustomerDetails.class);
		customersMockList.add(customerDetails);
		Mockito.when(customerJpaRepository.findAll()).thenReturn(customersMockList);
		
		List<ApplianceDetails> applianceStatusMockList= new ArrayList<>();
		ApplianceDetails applianaceDetails = Mockito.mock(ApplianceDetails.class);
		applianceStatusMockList.add(applianaceDetails);
		Mockito.when(applianceJpaRepository.findByCustomerId(Mockito.anyInt())).thenReturn(applianceStatusMockList);
		
		assertNotNull(applianceService.getApplianceConnectionStatus());
		
	}
	
	@Test
	public void testUpdateConnectionStatus() {
		
		doNothing().when(applianceJpaRepository).updateConnectionStatus(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt());
		applianceService.updateApplianceConnection(applianceInfo);
		 verify(applianceJpaRepository).updateConnectionStatus(applianceInfo.getStatus(),applianceInfo.getApplianceId(),applianceInfo.getCustomerId());
		
	}

}
