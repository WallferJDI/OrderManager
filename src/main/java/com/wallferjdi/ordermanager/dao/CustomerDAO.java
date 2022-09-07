package com.wallferjdi.ordermanager.dao;

import com.wallferjdi.ordermanager.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDAO extends JpaRepository<Customer,Long> {
    Optional<Customer> findCustomerByRegistrationCode(Long registrationCode);
}
