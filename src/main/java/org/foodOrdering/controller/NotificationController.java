package org.foodOrdering.controller;

import org.foodOrdering.Exception.UserException;
import org.foodOrdering.model.Notification;
import org.foodOrdering.model.User;
import org.foodOrdering.service.NotificationService;
import org.foodOrdering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotificationController {

	private final NotificationService notificationService;
	private final UserService userService;

	@Autowired
	public NotificationController(NotificationService notificationService, UserService userService) {
		this.notificationService = notificationService;
		this.userService = userService;
	}

	
	@GetMapping("/notifications")
	public ResponseEntity<List<Notification>> findUsersNotification(
			@RequestHeader("Authorization") String jwt) throws UserException {
		User user=userService.findUserProfileByJwt(jwt);
		
		List<Notification> notifications=notificationService.findUsersNotification(user.getId());
		return new ResponseEntity<List<Notification>>(notifications, HttpStatus.ACCEPTED);
	}

}
