package com.digital.notification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.digital.notification.model.ApplianceDetails;


@Component
public interface ApplianceJpaRepository extends JpaRepository<ApplianceDetails, Long>{

	List<ApplianceDetails> findByCustomerId(int customerId);

	@Modifying
	@Transactional
	@Query("update ApplianceDetails a set a.status = :status where a.applianceId=:applianceId and a.customerId=:customerId")
	void updateConnectionStatus(@Param("status") String status,@Param("applianceId") String applianceId,@Param("customerId") int customerId);

}
