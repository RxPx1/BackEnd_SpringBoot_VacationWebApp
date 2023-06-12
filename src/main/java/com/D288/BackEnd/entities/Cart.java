package com.D288.BackEnd.entities;


import com.D288.BackEnd.StatusType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Cart {


    private Long id;
    private String orderTrackingNumber;
    private BigDecimal package_price;
    private int party_size;
    private StatusType status;
    private Date create_date;
    private Date last_update;
    private Customer customer;
    private Set<CartItem> cartItem;

    public Cart(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
