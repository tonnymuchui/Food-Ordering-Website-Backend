package com.food_ordering.service;

import java.util.List;

import com.food_ordering.Exception.ReviewException;
import com.food_ordering.model.Review;
import com.food_ordering.model.User;
import com.food_ordering.request.ReviewRequest;

public interface ReviewSerive {
	
    public Review submitReview(ReviewRequest review,User user);
    public void deleteReview(Long reviewId) throws ReviewException;
    public double calculateAverageRating(List<Review> reviews);
}
