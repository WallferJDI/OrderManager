package com.wallferjdi.ordermanager.service;

import com.wallferjdi.ordermanager.dao.ProductDAO;
import com.wallferjdi.ordermanager.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private final ProductDAO productDAO;


    @Autowired
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Product createProduct(Product product){
       return productDAO.save(product);
    }
    public Optional<Product> getProductByScuCode(Long code){ return productDAO.findBySkuCode(code);}
}
