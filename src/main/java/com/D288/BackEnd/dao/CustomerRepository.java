package com.D288.BackEnd.dao;

import com.D288.BackEnd.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
