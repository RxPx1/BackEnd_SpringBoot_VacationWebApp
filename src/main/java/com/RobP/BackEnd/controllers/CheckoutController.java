package com.RobP.BackEnd.controllers;

import com.RobP.BackEnd.services.CheckoutService;
import com.RobP.BackEnd.services.PurchaseData;
import com.RobP.BackEnd.services.PurchaseResponseData;
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
        PurchaseResponseData purchaseResponse = checkoutService.placeOrder(purchaseData);
        return purchaseResponse;
    }

    @GetMapping("/cart-summary")
    public String getCartSummary(){
        return "Cart Summary";
    }

    @GetMapping("/order-confirmation")
    public String getOrderConfirmation(){
        return "Order Confirmed";
    }
}
