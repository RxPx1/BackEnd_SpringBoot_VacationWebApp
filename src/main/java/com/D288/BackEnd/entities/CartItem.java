package com.D288.BackEnd.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Vacation is required")
    @ManyToOne
    private Vacation vacation;

    @NotEmpty(message = "Excursion is required")
    @ManyToMany
    private Set<Excursion> excursions;

    @NotNull(message = "Cart is required")
    @ManyToOne
    private Cart cart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    @NotNull(message = "Date is required")
    private Date create_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    @NotNull(message = "Last update is required")
    private Date last_update;

    public CartItem(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
