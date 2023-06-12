package com.D288.BackEnd.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Excursion {
    private Long id;
    private String excursion_title;
    private String image_URL;
    private Date create_date;
    private Date last_update;
    private Vacation vacation;
    private Set<CartItem> cartItems;

    public Excursion(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
