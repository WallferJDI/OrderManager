package com.wallferjdi.ordermanager.dao;

import com.wallferjdi.ordermanager.model.Customer;
import com.wallferjdi.ordermanager.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<Order,Long> {

    List<Order> findAllBySubmissionDate(LocalDateTime localDateTime);
    List<Order> findAllOrderByCustomer(Customer customer);

}
