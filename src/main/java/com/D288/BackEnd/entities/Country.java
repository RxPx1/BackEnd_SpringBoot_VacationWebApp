package com.D288.BackEnd.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Country {
    private Long id;
    private String country_name;
    private Date create_date;
    private Date last_update;
    private Set<Division> divisions;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
