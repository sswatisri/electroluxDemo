package com.digital.notification.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="appliancedetails")
public class ApplianceDetails {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer id;
	@Column(name="appliance_id")
	private String applianceId;
	
	@Column(name="factory_number")
	private String factoryNumber;
	
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="status")
	private String status;
	
	
	

}
