package com.D288.BackEnd.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
public class CartItem {
    private Long id;
    private Vacation vacation;
    private Set<Excursion> excursions;
    private Cart cart;
    private Date create_date;
    private Date last_update;

    public CartItem(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
