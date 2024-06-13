package com.food_ordering.service;

import java.util.List;

import com.food_ordering.Exception.RestaurantException;
import com.food_ordering.model.Category;

public interface CategoryService {
	
	public Category createCategory (String name,Long userId) throws RestaurantException;
	public List<Category> findCategoryByRestaurantId(Long restaurantId) throws RestaurantException;
	public Category findCategoryById(Long id) throws RestaurantException;

}
