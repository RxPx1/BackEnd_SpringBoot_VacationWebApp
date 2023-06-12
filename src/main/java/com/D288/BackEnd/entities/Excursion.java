package com.D288.BackEnd.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "excursion")
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Excursion is required")
    private String excursion_title;

    @NotBlank(message = "Image URL is required")
    private String image_URL;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    @NotNull(message = "Date is required")
    private Date create_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    @NotNull(message = "Last update is required")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "vacation_id")
    @NotNull(message = "Vacation is required")
    private Vacation vacation;

    @ManyToMany(mappedBy = "excursion", cascade = CascadeType.ALL)
    private Set<CartItem> cartItems;

    public Excursion(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
