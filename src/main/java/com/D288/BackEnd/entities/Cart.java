package com.D288.BackEnd.entities;


import com.D288.BackEnd.StatusType;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
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
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "cart_id")
    private Long id;

    @NotBlank(message = "Tracking number is required")
    @Column(name= "order_tracking_number")
    private String orderTrackingNumber;

    @NotNull(message = "Package price is required")
    @DecimalMin(value = "0.0", inclusive = false, message= "The Price must be greater than 0")
    @Column(name= "package_price")
    private BigDecimal package_price;

    @Min(value = 1, message = "Size must be at least 1")
    @Column(name= "party_size")
    private int party_size;

    @NotNull(message = "Status is required")
    @Column(name= "status")
    private StatusType status;

    @CreationTimestamp
    @Column(name = "create_date")
    @NotNull(message = "Date is required")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    @NotNull(message = "Last update is required")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customers;

    @OneToMany(mappedBy = "carts", cascade = CascadeType.ALL)
    private Set<CartItem> cartItem = new HashSet<>();

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
