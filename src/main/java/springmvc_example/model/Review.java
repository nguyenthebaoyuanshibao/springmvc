package springmvc_example.model;

import java.util.Date;

public class Review {
	
	// レビューりID
		private String reviewId;
		
		private String userId;
		
		private String productId;

		private String reviewInfo;
		
		private Integer rateNumber;

		// 作成日
		private Date createAt;

		// 更新日
		private Date updateAt;

        

		/* Construction */
		public Review() {
				
			}



		public Review(String reviewId, String userId, String productId, String reviewInfo ) {
			super();
			this.reviewId = reviewId;
			this.userId = userId;
			this.productId = productId;
			this.reviewInfo = reviewInfo;
		}



		public String getReviewId() {
			return reviewId;
		}



		public void setReviewId(String reviewId) {
			this.reviewId = reviewId;
		}



		public String getUserId() {
			return userId;
		}



		public void setUserId(String userId) {
			this.userId = userId;
		}



		public String getProductId() {
			return productId;
		}



		public void setProductId(String productId) {
			this.productId = productId;
		}



		public String getReviewInfo() {
			return reviewInfo;
		}



		public void setReviewInfo(String reviewInfo) {
			this.reviewInfo = reviewInfo;
		}



		public Integer getRateNumber() {
			return rateNumber;
		}



		public void setRateNumber(Integer rateNumber) {
			this.rateNumber = rateNumber;
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
