package com.D288.BackEnd.services;

import org.springframework.stereotype.Service;

@Service
public interface CheckoutService {

    PurchaseResponseData placeOrder(PurchaseData purchaseData);
}
