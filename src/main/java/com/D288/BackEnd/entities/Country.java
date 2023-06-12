package com.D288.BackEnd.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message= "Country name is required")
    private String country_name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    @NotNull(message = "Date is required")
    private Date create_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    @NotNull(message = "Last update is required")
    private Date last_update;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @NotEmpty(message = "Divisions are required")
    private Set<Division> divisions;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
