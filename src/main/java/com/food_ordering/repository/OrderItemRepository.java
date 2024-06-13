package com.food_ordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food_ordering.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
