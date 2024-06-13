package com.food_ordering.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food_ordering.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	 Optional<Cart> findByCustomer_Id(Long userId);
}
