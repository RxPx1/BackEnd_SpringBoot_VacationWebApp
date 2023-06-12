package com.D288.BackEnd.services;



public class CheckoutServiceImpl implements CheckoutService{


    @Override
    public PurchaseResponseData checkout(PurchaseData purchaseData){

        PurchaseResponseData response = new PurchaseResponseData();
        response.setOrderTrackingNumber(generateOrderTrackingNumber());
        return response;
    }

    private String generateOrderTrackingNumber(){
        return "#1234";
    }
}
