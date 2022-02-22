package com.digital.notification.repository;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.digital.notification.model.ApplianceDetails;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class ApplianceJpaRepositoryTest {
	@Autowired
	ApplianceJpaRepository applianceJpaRepository;

	@Test
	public void testRepository() {
		ApplianceDetails applianaceDetails = new ApplianceDetails();
		applianaceDetails.setApplianceId("YS2R4X20005399401");
		applianaceDetails.setCustomerId(1001);
		applianaceDetails.setFactoryNumber("ABC123");
		applianaceDetails.setStatus("Connected");

		applianceJpaRepository.findAll();

		assertNotNull(applianaceDetails.getApplianceId());
	}

}
