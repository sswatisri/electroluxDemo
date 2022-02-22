package com.digital.notification.model;

import lombok.Data;

@Data
public class CustomerApplianceStatus {
	
	private String customerName;
	private String address;
	private String applianceId;
	private String factoryNumber;
	private String status;

}
