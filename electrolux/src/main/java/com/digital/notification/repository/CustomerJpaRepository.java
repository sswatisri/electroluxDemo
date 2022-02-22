package com.digital.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digital.notification.model.*;

public interface CustomerJpaRepository extends JpaRepository<CustomerDetails, Long>{

}
