package com.RobP.BackEnd.services;

import com.RobP.BackEnd.entities.Cart;
import com.RobP.BackEnd.entities.CartItem;
import com.RobP.BackEnd.entities.Customer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Set;



@Data
@Service
@Getter
@Setter
public class PurchaseData {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

}
