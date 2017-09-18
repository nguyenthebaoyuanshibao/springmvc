package springmvc_example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc_example.dao.ReviewDao;
import springmvc_example.model.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Override
	public List<Review> getReviewByProductId(Integer productId) {
		
		return reviewDao.getReviewByProductId(productId);
	}

	@Override
	public void deleteReviewByProductId(Integer productId) {
		
	 reviewDao.deleteReviewByProductId(productId);
		
	}


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
