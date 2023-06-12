package com.D288.BackEnd.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Division {
    private Long id;
    private String division_name;
    private Date create_date;
    private Date last_update;
    private Country country;



    public Division() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
