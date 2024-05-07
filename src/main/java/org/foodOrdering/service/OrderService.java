package org.foodOrdering.service;

import com.stripe.exception.StripeException;
import org.foodOrdering.Exception.CartException;
import org.foodOrdering.Exception.OrderException;
import org.foodOrdering.Exception.RestaurantException;
import org.foodOrdering.Exception.UserException;
import org.foodOrdering.model.Order;
import org.foodOrdering.model.PaymentResponse;
import org.foodOrdering.model.User;
import org.foodOrdering.request.CreateOrderRequest;

import java.util.List;

public interface OrderService {
	
	 public PaymentResponse createOrder(CreateOrderRequest order, User user) throws UserException, RestaurantException, CartException, CartException, OrderException, StripeException;
	 
	 public Order updateOrder(Long orderId, String orderStatus) throws OrderException;
	 
	 public void cancelOrder(Long orderId) throws OrderException;
	 
	 public List<Order> getUserOrders(Long userId) throws OrderException;
	 
	 public List<Order> getOrdersOfRestaurant(Long restaurantId,String orderStatus) throws OrderException, RestaurantException;
	 

}
