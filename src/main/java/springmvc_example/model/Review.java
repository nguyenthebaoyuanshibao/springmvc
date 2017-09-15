package springmvc_example.model;

import java.util.Date;

public class Review {
	
	// レビューりID
		private Integer reviewId;
		private String userId;
		private Integer productId;
		private String reviewInfo;
		private Integer ratingNumber;
		// 作成日
		private Date createAt;

		// 更新日
		private Date updateAt;

        

		/* Construction */
		public Review() {
				
			}



		public Review(Integer reviewId, String userId, Integer productId, String reviewInfo, Integer ratingNumber ) {
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



		public String getUserId() {
			return userId;
		}



		public void setUserId(String userId) {
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



		public Date getCreateAt() {
			return createAt;
		}



		public void setCreateAt(Date createAt) {
			this.createAt = createAt;
		}



		public Date getUpdateAt() {
			return updateAt;
		}



		public void setUpdateAt(Date updateAt) {
			this.updateAt = updateAt;
		}
		
		
}
