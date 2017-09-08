package springmvc_example.dao;

import springmvc_example.model.Review;

public interface ReviewDao {
	
	void addReview(String reviewId, String userId, String productId);
	Review updateReview(String reviewId);
	void deleteReview(String reviewId);

}
