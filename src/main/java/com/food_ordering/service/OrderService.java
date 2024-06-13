package com.food_ordering.service;

import java.util.List;

import com.stripe.exception.StripeException;
import com.food_ordering.Exception.CartException;
import com.food_ordering.Exception.OrderException;
import com.food_ordering.Exception.RestaurantException;
import com.food_ordering.Exception.UserException;
import com.food_ordering.model.Order;
import com.food_ordering.model.PaymentResponse;
import com.food_ordering.model.User;
import com.food_ordering.request.CreateOrderRequest;

public interface OrderService {
	
	 public PaymentResponse createOrder(CreateOrderRequest order, User user) throws UserException, RestaurantException, CartException, StripeException;
	 
	 public Order updateOrder(Long orderId, String orderStatus) throws OrderException;
	 
	 public void cancelOrder(Long orderId) throws OrderException;
	 
	 public List<Order> getUserOrders(Long userId) throws OrderException;
	 
	 public List<Order> getOrdersOfRestaurant(Long restaurantId,String orderStatus) throws OrderException, RestaurantException;
	 

}
