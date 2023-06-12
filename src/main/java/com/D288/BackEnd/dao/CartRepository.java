package com.D288.BackEnd.dao;

import com.D288.BackEnd.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
