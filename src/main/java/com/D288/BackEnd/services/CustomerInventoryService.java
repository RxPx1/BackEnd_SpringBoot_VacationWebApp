package com.D288.BackEnd.services;

import com.D288.BackEnd.dao.CustomerRepository;
import com.D288.BackEnd.entities.Customer;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class CustomerInventoryService {


    private final CustomerRepository customerRepository;

    public void initializeCustomers(){
        if(customerRepository.count() <= 1){
            Customer customer1 = createCustomer("Dave", "Casey", "222 Latrobe Lane", "15650", "7242472222");
            Customer customer2 = createCustomer("Tommy", "Porter", "333 Latrobe Lane", "15650", "7242473333");
            Customer customer3 = createCustomer("Nicole", "Robinson", "444 Latrobe Lane", "15650", "7242474444");
            Customer customer4 = createCustomer("Adam", "Goodlin", "555 Latrobe Lane", "15650", "7242475555");
            Customer customer5 = createCustomer("Kaitlyn", "Long", "777 Latrobe Lane", "15650", "7242477777");

            customerRepository.saveAll(List.of(customer1, customer2, customer3, customer4, customer5));
        }
    }

    private Customer createCustomer(String firstName, String lastName, String address, String postal_code, String phone){
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setAddress(address);
        customer.setPostal_code(postal_code);
        customer.setPhone(phone);
        return customer;


    }

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
