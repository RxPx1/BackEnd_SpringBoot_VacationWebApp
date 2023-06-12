package com.D288.BackEnd.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Postal code is required")
    private String postal_code;

    @NotBlank(message = "Phone number is required")
    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    @NotNull(message = "Date is required")
    private Date create_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    @NotNull(message = "Last update is required")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "division_id")
    @NotNull(message = "Division is required")
    private Division division;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Cart> carts;

    public Customer() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
