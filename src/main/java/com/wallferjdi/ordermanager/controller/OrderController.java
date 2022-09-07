package com.wallferjdi.ordermanager.controller;

import com.wallferjdi.ordermanager.model.Customer;
import com.wallferjdi.ordermanager.model.Order;
import com.wallferjdi.ordermanager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<Order> createProduct(@RequestBody Order order){
        System.out.println(LocalDateTime.now());
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.OK);
    }

    @GetMapping("/date")
    public ResponseEntity<List<Order>> getOrderByDate(@RequestBody LocalDateTime localDateTime){
        return new ResponseEntity<>(orderService.getOrdersByDate(localDateTime), HttpStatus.OK);
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Order>> getOrdersBuCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(orderService.getOrdersByCustomer(customer), HttpStatus.OK);
    }

}
