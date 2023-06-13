package com.D288.BackEnd.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name= "vacations")
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    @NotBlank(message = "Vacation title is required")
    @Column(name = "vacation_title")
    private String vacation_title;

    @NotBlank(message = "Description is required")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Travel price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Travel price is required")
    @Column(name = "travel_fare_price")
    private BigDecimal travel_price;

    @NotBlank(message = "Image URL is required")
    @Column(name = "image_url")
    private String image_URL;

    @CreationTimestamp
    @Column(name = "create_date")
    @NotNull(message = "Date is required")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    @NotNull(message = "Last update is required")
    private Date last_update;

    @OneToMany(mappedBy = "vacations", cascade = CascadeType.ALL)
    private Set<Excursion> excursions = new HashSet<>();

    public Vacation() {

    }
}
