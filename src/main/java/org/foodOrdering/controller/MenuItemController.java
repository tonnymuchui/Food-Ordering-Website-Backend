package org.foodOrdering.controller;

import org.foodOrdering.Exception.FoodException;
import org.foodOrdering.model.Food;
import org.foodOrdering.service.FoodService;
import org.foodOrdering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class MenuItemController {

	private final FoodService menuItemService;
	private final UserService userService;

	@Autowired
	public MenuItemController(FoodService menuItemService, UserService userService) {
		this.menuItemService = menuItemService;
		this.userService = userService;
	}


	@GetMapping("/search")
	public ResponseEntity<List<Food>> searchFood(
			@RequestParam String name)  {
		List<Food> menuItem = menuItemService.searchFood(name);
		return ResponseEntity.ok(menuItem);
	}
	@GetMapping("/restaurant/{restaurantId}")
	public ResponseEntity<List<Food>> getMenuItemByRestaurantId(
			@PathVariable Long restaurantId,
			@RequestParam boolean vegetarian,
			@RequestParam boolean seasonal,
			@RequestParam boolean nonveg,
			@RequestParam(required = false) String food_category) throws FoodException {
		List<Food> menuItems= menuItemService.getRestaurantsFood(
				restaurantId,vegetarian,nonveg,seasonal,food_category);
		return ResponseEntity.ok(menuItems);
	}
	


}
