package com.food_ordering.service;

import java.util.List;

import com.food_ordering.model.Notification;
import com.food_ordering.model.Order;
import com.food_ordering.model.Restaurant;
import com.food_ordering.model.User;

public interface NotificationService {
	
	public Notification sendOrderStatusNotification(Order order);
	public void sendRestaurantNotification(Restaurant restaurant, String message);
	public void sendPromotionalNotification(User user, String message);
	
	public List<Notification> findUsersNotification(Long userId);

}
