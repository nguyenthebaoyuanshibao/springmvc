package springmvc_example.model;

import java.util.Date;

public class Review {
	
	// レビューりID
		private String reviewId;
		
		private Integer userId;
		
		private String productId;

		private String content;

		// 作成日
		private Date createAt;

		// 更新日
		private Date updateAt;



		/* Construction */
		public Review() {
				
			}



		public Review(String reviewId, Integer userId, String productId, String content, Date createAt, Date updateAt) {
			super();
			this.reviewId = reviewId;
			this.userId = userId;
			this.productId = productId;
			this.content = content;
			this.createAt = createAt;
			this.updateAt = updateAt;
		}



		public String getReviewId() {
			return reviewId;
		}



		public void setReviewId(String reviewId) {
			this.reviewId = reviewId;
		}



		public Integer getUserId() {
			return userId;
		}



		public void setUserId(Integer userId) {
			this.userId = userId;
		}



		public String getProductId() {
			return productId;
		}



		public void setProductId(String productId) {
			this.productId = productId;
		}



		public String getContent() {
			return content;
		}



		public void setContent(String content) {
			this.content = content;
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
