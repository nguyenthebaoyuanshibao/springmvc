package springmvc_example.model;

import java.sql.Timestamp;
import java.util.Date;

public class Review {

	// レビューID
	private Integer reviewId;
	
	//ユーザーID
	private Integer userId;
	
	//商品ID
	private Integer productId;
	
	// 評価
	private String reviewInfo;
	
	//星の数（１から５まで）
	private Integer ratingNumber;
	
	// 作成日
	private Timestamp createAt;

	// 更新日
	private Timestamp updateAt;

	/* Construction */
	public Review() {

	}

	public Review(Integer reviewId, Integer userId, Integer productId, String reviewInfo, Integer ratingNumber) {
		
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.productId = productId;
		this.reviewInfo = reviewInfo;
		this.ratingNumber = ratingNumber;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getReviewInfo() {
		return reviewInfo;
	}

	public void setReviewInfo(String reviewInfo) {
		this.reviewInfo = reviewInfo;
	}

	public Integer getRatingNumber() {
		return ratingNumber;
	}

	public void setRatingNumber(Integer ratingNumber) {
		this.ratingNumber = ratingNumber;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

}
