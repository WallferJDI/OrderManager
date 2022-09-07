package com.wallferjdi.ordermanager.model;
import com.wallferjdi.ordermanager.annotation.ValidEmail;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long registrationCode;
    @Column(nullable = false)
    private String fullName;
    @Column(unique = true)
    @ValidEmail
    private String email;
    @Column(unique = true)
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "customer",orphanRemoval = true)
    private List<Order> orders;
}
