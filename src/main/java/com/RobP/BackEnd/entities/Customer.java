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
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "customer_id")
    private Long id;


    @Column(name= "customer_first_name")
    private String firstName;


    @Column(name= "customer_last_name")
    private String lastName;


    @Column(name= "address")
    private String address;


    @Column(name= "postal_code")
    private String postal_code;


    @Column(name= "phone")
    private String phone;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
    private Set<Cart> carts = new HashSet<>();

    public Customer() {

    }

    public void add(Cart cart){
        if(cart != null){
            if(carts == null){
                carts = new HashSet<>();
            }
            carts.add(cart);
            cart.setCustomers(this);
        }
    }


}
