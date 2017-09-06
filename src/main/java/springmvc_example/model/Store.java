package springmvc_example.model;

import java.util.Date;
import java.util.List;

public class Store {
	
	// ストアーID
		private String storeId;
		
		private Integer userId;
		
		// ストアー名
		private String storeName;
		
		// ストアーアドレス
		private String storeAddress;
		
		// 作成日
		private Date createAt;
		
		// 更新日
		private Date updateAt;
		
		//プロダクのリスト
		private List<Product> products;
		
		/* Construction */
		public Store() {
			
		}
		
		public Store(String storeId, String storeName, String storeAddress, Date createAt, Date updateAt,Integer userId, List<Product> products) {
			super();
			this.storeId = storeId;
			this.storeName = storeName;
			this.storeAddress = storeAddress;
			this.createAt = createAt;
			this.updateAt = updateAt;
			this.userId = userId;
			this.products = products;
		}

		/**
		 * @return the storeId
		 */
		public String getStoreId() {
			return storeId;
		}

		/**
		 * @param storeId
		 */
		public void setStoreId(String storeId) {
			this.storeId = storeId;
		}

		/**
		 * @return the storeName
		 */
		public String getStoreName() {
			return storeName;
		}

		/**
		 * @param storeName
		 */
		public void setStoreName(String storeName) {
			this.storeName = storeName;
		}

		/**
		 * @return the storeAddress
		 */
		public String getStoreAddress() {
			return storeAddress;
		}

		/**
		 * @param storeAddress
		 */
		public void setStoreAddress(String storeAddress) {
			this.storeAddress = storeAddress;
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

		/**
		 * @return the products
		 */
		public List<Product> getProducts() {
			return products;
		}

		/**
		 * @param products 
		 */
		public void setProducts(List<Product> products) {
			this.products = products;
		}

}
