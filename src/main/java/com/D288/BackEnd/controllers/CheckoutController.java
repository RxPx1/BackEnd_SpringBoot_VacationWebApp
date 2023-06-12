package com.D288.BackEnd.controllers;


import com.D288.BackEnd.entities.Cart;
import com.D288.BackEnd.entities.CartItem;
import com.D288.BackEnd.entities.Customer;
import com.D288.BackEnd.entities.Vacation;
import com.D288.BackEnd.services.CheckoutService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestBody Cart cart){
        if(cart == null || cart.getCustomer() == null || cart.getCartItems() == null || cart.getCartItems().isEmpty()){
            return ResponseEntity.badRequest().body("Invalid cart data");
        }

        Customer customer = cart.getCustomer();
        if(customer.getFirstName() == null || customer.getLastName() == null || customer.getAddress() == null ||
        customer.getPostal_code() == null || customer.getPhone() == null || customer.getDivision() == null){
            return ResponseEntity.badRequest().body("Invalid customer data");
        }

        for (CartItem cartItem : cart.getCartItems()){
            Vacation vacation = cartItem.getVacation();
            if(vacation.getVacation_title() ==null || vacation.getDescription() == null ||
            vacation.getTravel_price() == null || vacation.getImage_URL() == null){
                return ResponseEntity.badRequest().body("Invalid cart item data");
            }
        }

        String orderTrackingNumber = checkoutService.placeOrder(cart);

        if(orderTrackingNumber != null){
            return ResponseEntity.ok(orderTrackingNumber);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to place order");
        }

    }

}
