package com.D288.BackEnd.services;

import com.D288.BackEnd.entities.Cart;
import com.D288.BackEnd.entities.CartItem;
import com.D288.BackEnd.entities.Customer;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Set;



@Data
public class PurchaseData {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
