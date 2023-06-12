package com.D288.BackEnd.dao;

import com.D288.BackEnd.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
