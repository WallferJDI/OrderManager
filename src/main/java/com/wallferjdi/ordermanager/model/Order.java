package com.wallferjdi.ordermanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class Order {
    @Id
    private Long id;
    @ManyToOne(fetch =  FetchType.LAZY)
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "order",orphanRemoval = true)
    private Set<OrderLine> orderLines;
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    @Column(updatable = false)
    private LocalDateTime submissionDate;

    @PrePersist
    protected void onCreate(){
        this.submissionDate = LocalDateTime.now();
    }
}
