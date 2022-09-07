package com.wallferjdi.ordermanager.service;

import com.wallferjdi.ordermanager.dao.OrderDAO;
import com.wallferjdi.ordermanager.model.Customer;
import com.wallferjdi.ordermanager.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class OrderService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);
    private final OrderDAO orderDAO;
    @Autowired
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public List<Order> getOrdersByDate(LocalDateTime localDateTime){
        return orderDAO.findAllBySubmissionDate(localDateTime);
    }

    public List<Order> getOrdersByCustomer(Customer customer){
        return orderDAO.findAllOrderByCustomer(customer);
    }

    public Order createOrder(Order order){
        return orderDAO.save(order);
    }
}
