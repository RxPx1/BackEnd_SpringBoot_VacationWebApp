package com.D288.BackEnd.entities;


import jakarta.persistence.*;
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
@Table(name = "excursions")
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "excursion_id")
    private Long id;

    @Column(name= "excursion_price")
    private BigDecimal excursion_price;

    @Column(name= "excursion_title")
    private String excursion_title;


    @Column(name= "image_url")
    private String image_URL;

    @CreationTimestamp
    @Column(name = "create_date")
    @NotNull(message = "Date is required")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    @NotNull(message = "Last update is required")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false)
    private Vacation vacations;

    @ManyToMany
    @JoinTable(name = "excursion_cartitem", joinColumns = @JoinColumn(name="excursion_id"), inverseJoinColumns = @JoinColumn(name = "cart_item_id"))
    private Set<CartItem> cartItems = new HashSet<>();


    public Excursion(){

    }

}
