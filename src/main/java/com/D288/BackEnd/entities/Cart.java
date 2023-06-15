package com.D288.BackEnd.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "cart_id")
    private Long id;


    @Column(name= "order_tracking_number")
    private String orderTrackingNumber;


    @Column(name= "package_price")
    private BigDecimal package_price;

    @Column(name= "party_size")
    private int party_size;

    @Enumerated(EnumType.STRING)
    @Column(name= "status")
    private StatusType status;


    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, insertable = false,updatable = false)
    private Customer customers;

    @OneToMany(mappedBy = "carts", cascade = CascadeType.ALL)
    private Set<CartItem> cartItem = new HashSet<>();

    @Column(name = "customer_id")
    private long customer_id;


    public void setCustomer(Customer customer){
        setCustomer_id(customer.getId());
        this.customers = customer;
    }

    public void add(CartItem item){
        if(item != null){
            if(cartItem == null){
                cartItem = new HashSet<>();
            }
            cartItem.add(item);
            item.setCarts(this);
        }
    }



    public Cart(){

    }
}
