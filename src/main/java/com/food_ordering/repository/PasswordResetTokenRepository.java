package com.food_ordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food_ordering.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
	PasswordResetToken findByToken(String token);
}
