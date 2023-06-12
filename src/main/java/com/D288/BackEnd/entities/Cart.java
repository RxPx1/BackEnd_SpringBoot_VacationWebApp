package com.D288.BackEnd.entities;


import com.D288.BackEnd.StatusType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tracking number is required")
    private String orderTrackingNumber;

    @NotNull(message = "Package price is required")
    @DecimalMin(value = "0.0", inclusive = false, message= "The Price must be greater than 0")
    private BigDecimal package_price;

    @Min(value = 1, message = "Size must be at least 1")
    private int party_size;

    @NotNull(message = "Status is required")
    private StatusType status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    @NotNull(message = "Date is required")
    private Date create_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    @NotNull(message = "Last update is required")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull(message = "Customer is required")
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartItem> cartItem;

    public Cart(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public Set<CartItem> getCartItems() {
        return cartItem;
    }
}
