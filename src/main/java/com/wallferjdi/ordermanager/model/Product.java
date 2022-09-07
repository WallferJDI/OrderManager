package com.wallferjdi.ordermanager.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Product {
    @Id
    private Long skuCode;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer price;
}
