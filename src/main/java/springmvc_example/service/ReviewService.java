package springmvc_example.service;

import java.util.List;

import springmvc_example.model.Review;

public interface ReviewService {
		
	//レビューを追加する。
		void addReview(Integer userId, Integer productId, String reviewInfo);
		
		//レビューを変更する。
		void updateReview(Integer reviewId, String reviewInfo);
		
		Review getReviewByReviewId(Integer reviewId);
		
		List<Review> getReviewByUserId(Integer userId);
		
		// Get Review By Product ID.
		List<Review> getReviewByProductId(Integer productId);
		
		//レピューID で レピューを削除する。
		void deleteReviewByReviewId(Integer reviewId);
		
		void deleteReviewByUserId(Integer userId);
		
		//productId で レピューを削除する。
		void deleteReviewByProductId(Integer productId);
}
