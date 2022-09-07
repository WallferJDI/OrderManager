package com.wallferjdi.ordermanager.dao;

import com.wallferjdi.ordermanager.model.Customer;
import com.wallferjdi.ordermanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductDAO extends JpaRepository<Product,Long> {
    Optional<Product> findBySkuCode(Long scuCode);
}
