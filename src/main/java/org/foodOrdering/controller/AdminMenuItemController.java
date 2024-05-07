package org.foodOrdering.controller;

import org.foodOrdering.Exception.FoodException;
import org.foodOrdering.Exception.RestaurantException;
import org.foodOrdering.Exception.UserException;
import org.foodOrdering.model.Food;
import org.foodOrdering.model.Restaurant;
import org.foodOrdering.model.User;
import org.foodOrdering.request.CreateFoodRequest;
import org.foodOrdering.service.CategoryService;
import org.foodOrdering.service.FoodService;
import org.foodOrdering.service.RestaurantService;
import org.foodOrdering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/food")
public class AdminMenuItemController {

	private final FoodService menuItemService;
	private final UserService userService;
	private final RestaurantService restaurantService;
	private final CategoryService categoryService;

	@Autowired
	public AdminMenuItemController(
			FoodService menuItemService,
			UserService userService,
			RestaurantService restaurantService,
			CategoryService categoryService) {
		this.menuItemService = menuItemService;
		this.userService = userService;
		this.restaurantService = restaurantService;
		this.categoryService = categoryService;
	}

	@PostMapping()
	public ResponseEntity<Food> createItem(
			@RequestBody CreateFoodRequest item,
			@RequestHeader("Authorization") String jwt)
			throws FoodException, UserException, RestaurantException {
		System.out.println("req-controller ----"+item);
		User user = userService.findUserProfileByJwt(jwt);
//		Category category=categoryService.findCategoryById(item.getCategoryId());
		Restaurant restaurant=restaurantService.findRestaurantById(item.getRestaurantId());
			Food menuItem = menuItemService.createFood(item,item.getCategory(),restaurant);
			return ResponseEntity.ok(menuItem);

	}


	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable Long id, @RequestHeader("Authorization") String jwt)
			throws UserException, FoodException {
		User user = userService.findUserProfileByJwt(jwt);
		
			menuItemService.deleteFood(id);
			return ResponseEntity.ok("Menu item deleted");
		
	
	}

	

	@GetMapping("/search")
	public ResponseEntity<List<Food>> getMenuItemByName(@RequestParam String name)  {
		List<Food> menuItem = menuItemService.searchFood(name);
		return ResponseEntity.ok(menuItem);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Food> updateAvilibilityStatus(
			@PathVariable Long id) throws FoodException {
		Food menuItems= menuItemService.updateAvailibilityStatus(id);
		return ResponseEntity.ok(menuItems);
	}
	
	

}
