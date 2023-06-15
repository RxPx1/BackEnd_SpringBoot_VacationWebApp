package com.D288.BackEnd.services;

import com.D288.BackEnd.dao.CustomerRepository;
import com.D288.BackEnd.entities.Cart;
import com.D288.BackEnd.entities.CartItem;
import com.D288.BackEnd.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    @Transactional
    public PurchaseResponseData placeOrder(PurchaseData purchaseData) {
        Cart cart = purchaseData.getCart();
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItem = purchaseData.getCartItems();
        cartItem.forEach(item -> cart.add(item));

        Customer customer = purchaseData.getCustomer();
        customer.add(cart);

        customerRepository.save(customer);

        return new PurchaseResponseData(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber(){
        return UUID.randomUUID().toString();
    }
}

