package com.D288.BackEnd.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "divisions")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "division_id")
    private Long id;

    @NotBlank(message = "Division name is required")
    @Column(name= "division")
    private String division_name;

    @CreationTimestamp
    @Column(name = "create_date")
    @NotNull(message = "Date is required")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    @NotNull(message = "Last update is required")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country countries;



    public Division() {

    }

}
