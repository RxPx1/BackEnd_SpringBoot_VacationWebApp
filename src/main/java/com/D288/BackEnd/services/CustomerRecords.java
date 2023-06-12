package com.D288.BackEnd.services;

import com.D288.BackEnd.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CustomerRecords  implements CommandLineRunner {

    private final EntityManager entityManager;


    public CustomerRecords(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if(countCustomer() == 0){
            addSampleCustomers();
        }
    }

    private long countCustomer(){
    return entityManager.createQuery("SELECT COUNT(c) FROM Customer c", Long.class)
            .getSingleResult();
    }

    private void addSampleCustomers(){
        Customer customer1 = new Customer("Dave", "Casey", "222 Latrobe Lane", "15650", "7247242222");
        Customer customer2 = new Customer("Denny", "Winer", "333 Latrobe Lane", "15650", "7247243333");
        Customer customer3 = new Customer("Nicole", "Robinson", "444 Latrobe Lane", "15650", "7247244444");
        Customer customer4 = new Customer("Kaitlyn", "Long", "555 Latrobe Lane", "15650", "7247245555");
        Customer customer5 = new Customer("Adam", "Goodlin", "777 Latrobe Lane", "15650", "7247247777");

        entityManager.persist(customer1);
        entityManager.persist(customer2);
        entityManager.persist(customer3);
        entityManager.persist(customer4);
        entityManager.persist(customer5);
    }

}

