package com.D288.BackEnd.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name= "vacation")
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Vacation title is required")
    private String vacation_title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Travel price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Travel price is required")
    private BigDecimal travel_price;

    @NotBlank(message = "Image URL is required")
    private String image_URL;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    @NotNull(message = "Date is required")
    private Date create_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    @NotNull(message = "Last update is required")
    private Date last_update;

    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL)
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
