package com.D288.BackEnd.services;


import com.D288.BackEnd.entities.Cart;
import org.springframework.stereotype.Service;

@Service
public interface CheckoutService {

    PurchaseResponseData checkout(PurchaseData purchaseData);

    String placeOrder(Cart cart);
}
