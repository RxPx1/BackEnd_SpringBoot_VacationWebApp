package com.D288.BackEnd.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "First name is required")
    @Column(name= "customer_first_name")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(name= "customer_last_name")
    private String lastName;

    @NotBlank(message = "Address is required")
    @Column(name= "address")
    private String address;

    @NotBlank(message = "Postal code is required")
    @Column(name= "postal_code")
    private String postal_code;

    @NotBlank(message = "Phone number is required")
    @Column(name= "phone")
    private String phone;

    @CreationTimestamp
    @Column(name = "create_date")
    @NotNull(message = "Date is required")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    @NotNull(message = "Last update is required")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
    private Set<Cart> carts = new HashSet<>();

    public void add(Cart cart){
        if(cart != null){
            if(carts == null){
                carts = new HashSet<>();
            }
            carts.add(cart);
            cart.setCustomers(this);
        }
    }

    public Customer() {

    }

}
