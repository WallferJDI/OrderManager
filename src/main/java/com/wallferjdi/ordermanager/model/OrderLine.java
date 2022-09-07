package com.wallferjdi.ordermanager.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderLine {

    @Id
    private Long id;
    @ManyToOne(fetch =  FetchType.LAZY)
    private Product product;
    @Column
    private Integer quantity;
    @ManyToOne(fetch =  FetchType.LAZY)
    private Order order;


}
