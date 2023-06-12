package com.D288.BackEnd.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Vacation {
    private Long id;
    private String vacation_title;
    private String description;
    private BigDecimal travel_price;
    private String image_URL;
    private Date create_date;
    private Date last_update;
    private Set<Excursion> excursions;

    public Vacation(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
