package springmvc_example.dao;

import java.util.List;

import springmvc_example.model.Review;

public interface ReviewDao {
	
	//レビューを追加する。
	void addReview(Integer reviewId, String userId, Integer productId);
	
	//レビューを変更する。
	Review updateReview(Integer reviewId);
	
	//レピューID で レピューを削除する。
	void deleteReviewByReviewId(Integer reviewId);
	
	// Get Review By Product ID.
	List<Review> getReviewByProductId(Integer productId);
	
	//productId で レピューを削除する。
	void deleteReviewByProductId(Integer productId);

}
