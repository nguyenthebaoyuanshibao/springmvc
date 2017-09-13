package springmvc_example.model;

import java.util.Date;

public class Sale {
	
	// 販売履歴のID
		private String saleId;

		private String userId;
		
		private String productId;
		
		private Integer price;
		// 作成日
		private Date createAt;

		// 更新日
		private Date updateAt;

		
		/* Construction */
		public Sale() {

		}

		public Sale(String saleId, String userId, String productId, Integer price) {
			super();
			this.saleId = saleId;
			this.userId = userId;
			this.productId = productId;
			this.price = price;
		}

		public String getSaleId() {
			return saleId;
		}

		public void setSaleId(String saleId) {
			this.saleId = saleId;
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
		
		public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
			this.price = price;
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
