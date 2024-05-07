package org.foodOrdering.controller;

import org.foodOrdering.Exception.RestaurantException;
import org.foodOrdering.Exception.UserException;
import org.foodOrdering.model.Restaurant;
import org.foodOrdering.model.User;
import org.foodOrdering.request.CreateRestaurantRequest;
import org.foodOrdering.response.ApiResponse;
import org.foodOrdering.service.RestaurantService;
import org.foodOrdering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/restaurants")
public class AdminRestaurantController {
	private final RestaurantService restaurantService;
	private final UserService userService;

	@Autowired
	public AdminRestaurantController(RestaurantService restaurantService, UserService userService) {
		this.restaurantService = restaurantService;
		this.userService = userService;
	}
	@PostMapping()
	public ResponseEntity<Restaurant> createRestaurant(
			@RequestBody CreateRestaurantRequest req,
			@RequestHeader("Authorization") String jwt) throws UserException {

			User user = userService.findUserProfileByJwt(jwt);
		
			System.out.println("----TRUE___-----"+jwt);
			Restaurant restaurant = restaurantService.createRestaurant(req,user);
			return ResponseEntity.ok(restaurant);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody CreateRestaurantRequest req,
			@RequestHeader("Authorization") String jwt) throws RestaurantException, UserException {
		User user = userService.findUserProfileByJwt(jwt);
		
			Restaurant restaurant = restaurantService.updateRestaurant(id, req);
			return ResponseEntity.ok(restaurant);
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteRestaurantById(@PathVariable("id") Long restaurantId,
															@RequestHeader("Authorization") String jwt) throws RestaurantException, UserException {
		User user = userService.findUserProfileByJwt(jwt);
		
			restaurantService.deleteRestaurant(restaurantId);
			
			ApiResponse res=new ApiResponse("Restaurant Deleted with id Successfully",true);
			return ResponseEntity.ok(res);
	}

	
	@PutMapping("/{id}/status")
	public ResponseEntity<Restaurant> updateStataurantStatus(
			@RequestHeader("Authorization") String jwt,
			@PathVariable Long id) throws RestaurantException, UserException {
		
			Restaurant restaurant = restaurantService.updateRestaurantStatus(id);
			return ResponseEntity.ok(restaurant);

	}

	@GetMapping("/user")
	public ResponseEntity<Restaurant> findRestaurantByUserId(
			@RequestHeader("Authorization") String jwt) throws RestaurantException, UserException {
		User user = userService.findUserProfileByJwt(jwt);
		Restaurant restaurant = restaurantService.getRestaurantsByUserId(user.getId());
		return ResponseEntity.ok(restaurant);

	}
	
	

}
