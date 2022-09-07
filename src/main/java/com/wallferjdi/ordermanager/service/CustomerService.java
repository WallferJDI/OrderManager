package com.wallferjdi.ordermanager.service;

import com.wallferjdi.ordermanager.dao.CustomerDAO;
import com.wallferjdi.ordermanager.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerDAO customerDAO;
    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public Customer createCustomer(Customer customer){
            return customerDAO.save(customer);
    }

    public Optional<Customer> getCustomer(Long registrationCode){
        return customerDAO.findCustomerByRegistrationCode(registrationCode);
    }
}
