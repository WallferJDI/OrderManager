package com.wallferjdi.ordermanager.controller;

import com.wallferjdi.ordermanager.model.Customer;
import com.wallferjdi.ordermanager.model.Product;
import com.wallferjdi.ordermanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{scu-code}")
    public ResponseEntity<Product> getProductByScuCode(@PathVariable("scu-code") String code){
        Product product = productService.getProductByScuCode(Long.parseLong(code) ).orElseThrow(()->new IllegalArgumentException("Product not exist"));
        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.OK);
    }
}
