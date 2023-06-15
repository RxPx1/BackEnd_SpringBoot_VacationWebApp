package com.RobP.BackEnd.services;

import com.RobP.BackEnd.dao.CustomerRepository;
import com.RobP.BackEnd.entities.Customer;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class CustomerInventoryService {


    private final CustomerRepository customerRepository;


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElse(null);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long customerId, Customer customer) {
        Customer existingCustomer = customerRepository.findById(customerId)
                .orElse(null);
        if(existingCustomer != null){
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setAddress(customer.getAddress());
            existingCustomer.setPostal_code(customer.getPostal_code());
            existingCustomer.setPhone(customer.getPhone());

            return customerRepository.save(existingCustomer);
        }
        return null;
    }
}
