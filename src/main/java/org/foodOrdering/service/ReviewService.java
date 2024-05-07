package org.foodOrdering.service;

import org.foodOrdering.Exception.ReviewException;
import org.foodOrdering.model.Review;
import org.foodOrdering.model.User;
import org.foodOrdering.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
	
    public Review submitReview(ReviewRequest review, User user);
    public void deleteReview(Long reviewId) throws ReviewException;
    public double calculateAverageRating(List<Review> reviews);
}
