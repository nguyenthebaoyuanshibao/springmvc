package springmvc_example.model;

import java.util.Date;

public class Sale {
	
	// 販売履歴のID
		private String saleId;

		private Integer userId;
		
		private String saleInfo;
		// 作成日
		private Date createAt;

		// 更新日
		private Date updateAt;

		
		/* Construction */
		public Sale() {

		}

		public Sale(String saleId, Integer userId, String saleInfo, Date createAt, Date updateAt) {
			super();
			this.saleId = saleId;
			this.userId = userId;
			this.saleInfo = saleInfo;
			this.createAt = createAt;
			this.updateAt = updateAt;
		}

		public String getSaleId() {
			return saleId;
		}

		public void setSaleId(String saleId) {
			this.saleId = saleId;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public String getsaleInfo() {
			return saleInfo;
		}

		public void setSaleInfo(String saleInfo) {
			this.saleInfo = saleInfo;
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
