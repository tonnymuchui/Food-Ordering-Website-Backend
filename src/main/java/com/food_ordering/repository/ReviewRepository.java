package com.food_ordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food_ordering.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
