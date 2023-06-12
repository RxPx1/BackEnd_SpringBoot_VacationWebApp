package com.D288.BackEnd.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String postal_code;
    private String phone;
    private Date create_date;
    private Date last_update;
    private Division division;
    private Set<Cart> carts;

    public Customer() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
