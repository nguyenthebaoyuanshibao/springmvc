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
	public void addReview(Integer userId, Integer productId, String reviewInfo) {
		// kiem tra xem user hien tai co quyen add review hay khong
       reviewDao.addReview(userId, productId, reviewInfo);
	}

	@Override
	public void updateReview(Integer reviewId, String reviewInfo) {
		// khi update can phai xac thuc xem user hien tai co phai la nguoi da review khong
		reviewDao.updateReview(reviewId, reviewInfo);
	}

	@Override
	public void deleteReviewByReviewId(Integer reviewId) {
		// khi delete can phai xac thuc xem user hien tai co phai la nguoi da review hoac la ADMIN khong

	}

	@Override
	public void deleteReviewByUserId(Integer userId) {
		reviewDao.deleteReviewByUserId(userId);
		
	}

	@Override
	public Review getReviewByReviewId(Integer reviewId) {
		
		return reviewDao.getReviewByReviewId(reviewId);
	}

	@Override
	public List<Review> getReviewByUserId(Integer userId) {
		
		return reviewDao.getReviewByUserId(userId);
	}
}
