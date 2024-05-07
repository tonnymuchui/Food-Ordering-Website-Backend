package org.foodOrdering.service;

import org.foodOrdering.Exception.FoodException;
import org.foodOrdering.Exception.RestaurantException;
import org.foodOrdering.model.Category;
import org.foodOrdering.model.Food;
import org.foodOrdering.model.Restaurant;
import org.foodOrdering.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {

	public Food createFood(CreateFoodRequest req, Category category,
						   Restaurant restaurant) throws FoodException, RestaurantException;

	void deleteFood(Long foodId) throws FoodException;
	
	public List<Food> getRestaurantsFood(Long restaurantId,
										 boolean isVegetarian, boolean isNonveg, boolean isSeasonal, String foodCategory) throws FoodException;
	
	public List<Food> searchFood(String keyword);
	
	public Food findFoodById(Long foodId) throws FoodException;

	public Food updateAvailibilityStatus(Long foodId) throws FoodException;
}
