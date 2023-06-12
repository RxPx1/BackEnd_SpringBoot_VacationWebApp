package com.D288.BackEnd.services;


import com.D288.BackEnd.entities.Cart;

public class CheckoutServiceImpl implements CheckoutService{


    @Override
    public PurchaseResponseData checkout(PurchaseData purchaseData){

        PurchaseResponseData response = new PurchaseResponseData();
        response.setOrderTrackingNumber(generateOrderTrackingNumber());
        return response;
    }

    @Override
    public String placeOrder(Cart cart) {
        String orderTrackingNumber = "#12345";
        return orderTrackingNumber;
    }

    private String generateOrderTrackingNumber(){
        return "#1234";
    }
}
