package com.D288.BackEnd.controllers;


import com.D288.BackEnd.entities.Customer;
import com.D288.BackEnd.services.CustomerInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    public CustomerInventoryService customerInventoryService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerInventoryService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId){
        Customer customer = customerInventoryService.getCustomerById(customerId);
        if(customer != null){
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/new")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer savedCustomer = customerInventoryService.addCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer){
        Customer updateCustomer = customerInventoryService.updateCustomer(customerId, customer);
        if(updateCustomer != null){
            return ResponseEntity.ok(updateCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
