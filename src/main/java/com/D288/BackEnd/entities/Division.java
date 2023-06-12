package com.D288.BackEnd.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "division")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Division name is required")
    private String division_name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    @NotNull(message = "Date is required")
    private Date create_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    @NotNull(message = "Last update is required")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @NotNull(message = "Country is required")
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
