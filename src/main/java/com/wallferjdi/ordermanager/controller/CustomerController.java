package com.wallferjdi.ordermanager.controller;

import com.wallferjdi.ordermanager.model.Customer;
import com.wallferjdi.ordermanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{reg-code}")
    public ResponseEntity<Customer> getCustomerByRegistrationCode(@PathVariable("reg-code") String code){
        Customer customer = customerService.getCustomer(Long.parseLong(code)).get();
        return new ResponseEntity<>(customer, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);

    }
}
