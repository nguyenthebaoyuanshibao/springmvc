package springmvc_example.service;

import java.util.List;

import springmvc_example.model.Review;

public interface ReviewService {
		
	//レビューを追加する。
		void addReview(Integer reviewId, Integer userId, Integer productId);
		
		//レビューを変更する。
		Review updateReview(Integer reviewId);
		
		//レピューID で レピューを削除する。
		void deleteReviewByReviewId(Integer reviewId);
		
		// Get Review By Product ID.
		List<Review> getReviewByProductId(Integer productId);
		
		//productId で レピューを削除する。
		void deleteReviewByProductId(Integer productId);
		
		void deleteReviewByUserId(Integer userId);
}
