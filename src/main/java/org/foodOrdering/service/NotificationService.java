package org.foodOrdering.service;

import org.foodOrdering.model.Notification;
import org.foodOrdering.model.Order;
import org.foodOrdering.model.Restaurant;
import org.foodOrdering.model.User;

import java.util.List;

public interface NotificationService {
	
	public Notification sendOrderStatusNotification(Order order);
	public void sendRestaurantNotification(Restaurant restaurant, String message);
	public void sendPromotionalNotification(User user, String message);
	
	public List<Notification> findUsersNotification(Long userId);

}
