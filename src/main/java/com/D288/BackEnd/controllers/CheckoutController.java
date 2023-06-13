package com.D288.BackEnd.controllers;

import com.D288.BackEnd.services.CheckoutService;
import com.D288.BackEnd.services.PurchaseData;
import com.D288.BackEnd.services.PurchaseResponseData;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponseData placeOrder(@RequestBody PurchaseData purchaseData){
        PurchaseResponseData purchaseResponseData = checkoutService.placeOrder(purchaseData);
        return purchaseResponseData;
    }

}
