package springmvc_example.model;

import java.util.Date;
import java.util.List;

public class Category {
	
	// カテゴリーID
		private String categoryId;

		// 作成日
		private Date createAt;

		// 更新日
		private Date updateAt;


		/* Construction */
		public Category() {

		}

		public Category(String categoryId, Date createAt, Date updateAt) {
			this.categoryId = categoryId;
			this.createAt = createAt;
			this.updateAt = updateAt;
		}

		/**
		 * @return the categoryId
		 */
		public String getCategoryId() {
			return categoryId;
		}

		/**
		 * @param categoryId
		 */
		public void setCategoryId(String categoryId) {
			this.categoryId = categoryId;
		}

		/**
		 * @return the categoryName
		 */
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

		

}
