package org.foodOrdering.controller;

import com.stripe.exception.StripeException;
import org.foodOrdering.Exception.CartException;
import org.foodOrdering.Exception.OrderException;
import org.foodOrdering.Exception.RestaurantException;
import org.foodOrdering.Exception.UserException;
import org.foodOrdering.model.Order;
import org.foodOrdering.model.PaymentResponse;
import org.foodOrdering.model.User;
import org.foodOrdering.request.CreateOrderRequest;
import org.foodOrdering.service.OrderService;
import org.foodOrdering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

	private final OrderService orderService;
	private final UserService userService;

	@Autowired
	public OrderController(OrderService orderService, UserService userService) {
		this.orderService = orderService;
		this.userService = userService;
	}
	
    @PostMapping("/order")
	public ResponseEntity<PaymentResponse> createOrder(@RequestBody CreateOrderRequest order,
													   @RequestHeader("Authorization") String jwt)
					throws UserException, RestaurantException,
			CartException,
			StripeException,
			OrderException {
		User user=userService.findUserProfileByJwt(jwt);
		System.out.println("req user "+user.getEmail());
    	if(order!=null) {
			PaymentResponse res = orderService.createOrder(order,user);
			return ResponseEntity.ok(res);
			
    	}else throw new OrderException("Please provide valid request body");
		
    }
    
 
    
    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getAllUserOrders(	@RequestHeader("Authorization") String jwt) throws OrderException, UserException{
    
    	User user=userService.findUserProfileByJwt(jwt);
    	
    	if(user.getId()!=null) {
    	List<Order> userOrders = orderService.getUserOrders(user.getId());
    	return ResponseEntity.ok(userOrders);
    	}else {
    		return new ResponseEntity<List<Order>>(HttpStatus.BAD_REQUEST);
    	}
    }
    

    

	
}
