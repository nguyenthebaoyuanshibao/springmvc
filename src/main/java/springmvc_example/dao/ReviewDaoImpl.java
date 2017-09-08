package springmvc_example.dao;

import org.springframework.stereotype.Repository;

import springmvc_example.model.Review;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	@Override
	public void addReview(String reviewId, String userId, String productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Review updateReview(String reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteReview(String reviewId) {
		// TODO Auto-generated method stub

	}

}
