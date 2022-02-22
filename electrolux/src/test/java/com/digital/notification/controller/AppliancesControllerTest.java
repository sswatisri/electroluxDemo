package com.digital.notification.controller;


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

import com.digital.notification.model.ApplianceInfo;
import com.digital.notification.model.CustomerApplianceStatus;
import com.digital.notification.service.ApplianceService;

@ExtendWith(MockitoExtension.class)
public class AppliancesControllerTest {

	@InjectMocks
	private AppliancesController appliancesController;

	private ApplianceService applianceService = Mockito.mock(ApplianceService.class);
	private ApplianceInfo applianceInfo = Mockito.mock(ApplianceInfo.class);

	@Test
	public void testGetApplienceConnectionStatus() {
		List<CustomerApplianceStatus> mockList = new ArrayList<>();
		CustomerApplianceStatus customerApplianceStatus = Mockito.mock(CustomerApplianceStatus.class);
		mockList.add(customerApplianceStatus);
		Mockito.when(applianceService.getApplianceConnectionStatus()).thenReturn(mockList);
		assertNotNull(appliancesController.getApplianceConnectionStatus());

	}
	
	@Test
	public void testUpdateApplianceConnection() {
		List<CustomerApplianceStatus> mockList = new ArrayList<>();
		CustomerApplianceStatus customerApplianceStatus = Mockito.mock(CustomerApplianceStatus.class);
		mockList.add(customerApplianceStatus);
		doNothing().when(applianceService).updateApplianceConnection(applianceInfo);
	   appliancesController.updateApplianceConnection(applianceInfo);
	   verify(applianceService).updateApplianceConnection(applianceInfo);

	}

}
