package com.food_ordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food_ordering.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


//    CartItem findByFoodIsContaining

}
