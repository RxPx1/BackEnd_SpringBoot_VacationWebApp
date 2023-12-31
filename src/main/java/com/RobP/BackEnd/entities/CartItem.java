package com.RobP.BackEnd.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "cart_item_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name= "vacation_id", nullable = false)
    private Vacation vacation;


    @ManyToMany
    @JoinTable(name= "excursion_cartitem", joinColumns = @JoinColumn(name="cart_item_id"), inverseJoinColumns = @JoinColumn(name="excursion_id"))
    private Set<Excursion> excursions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name= "cart_id", nullable = false)
    private Cart carts;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    public CartItem(){

    }

}
