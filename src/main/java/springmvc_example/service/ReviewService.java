package springmvc_example.service;

import java.util.List;

import springmvc_example.model.Review;

public interface ReviewService {
		
	Review updateReview(String reviewId);
	
	void deleteReview(String reviewId);
    
	List<Review> getReviewByProductId(Integer productId);
	
	void addReview(String reviewId, String userId, String productId);
	
	void deleteReviewByProductId(Integer productId);
}
