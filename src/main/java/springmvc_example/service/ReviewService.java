package springmvc_example.service;

import springmvc_example.model.Review;

public interface ReviewService {
	
	void addReview(String reviewId, String userId, String productId);
	Review updateReview(String reviewId);
	void deleteReview(String reviewId);

}
