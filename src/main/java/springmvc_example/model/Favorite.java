package springmvc_example.model;

import java.util.Date;

public class Favorite {
	
	// お気に入りID
		private String favoriteId;

		// 評価
		private Integer rating;

		// 作成日
		private Date createAt;

		// 更新日
		private Date updateAt;

		// ユーザ
		private Integer userId;
		
		// プロダクト
		private String productId;

		/* Construction */
		public Favorite() {
				
			}
		
		public Favorite(String favoriteId, Integer rating, Date createAt, Date updateAt, Integer userId, String productId) {
			super();
			this.favoriteId = favoriteId;
			this.rating = rating;
			this.createAt = createAt;
			this.updateAt = updateAt;
			this.userId = userId;
			this.productId = productId;
		}

		/**
		 * @return the favoriteId
		 */
		public String getFavoriteId() {
			return favoriteId;
		}

		/**
		 * @param favoriteId
		 */
		public void setFavoriteId(String favoriteId) {
			this.favoriteId = favoriteId;
		}

		/**
		 * @return the rating
		 */
		public Integer getRating() {
			return rating;
		}

		/**
		 * @param rating
		 */
		public void setRating(Integer rating) {
			this.rating = rating;
		}

		/**
		 * @return the createAt
		 */
		public Date getCreateAt() {
			return createAt;
		}

		/**
		 * @param createAt
		 */
		public void setCreateAt(Date createAt) {
			this.createAt = createAt;
		}

		/**
		 * @return the updateAt
		 */
		public Date getUpdateAt() {
			return updateAt;
		}

		/**
		 * @param updateAt
		 */
		public void setUpdateAt(Date updateAt) {
			this.updateAt = updateAt;
		}

		/**
		 * @return the user
		 */
		public Integer getUserId() {
			return userId;
		}

		/**
		 * @param user
		 */
		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		/**
		 * @return the product
		 */
		public String getProductId() {
			return productId;
		}

		/**
		 * @param product
		 */
		public void setProductId(String productId) {
			this.productId = productId;
		}

}
