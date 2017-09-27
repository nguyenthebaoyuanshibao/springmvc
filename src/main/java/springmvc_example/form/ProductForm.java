package springmvc_example.form;

public class ProductForm {
	
	//商品ID
		private Integer productId;
		
		//商品の写真のアドレス
		private String url;
		
		//商品のカテゴリ
		private String categoryId;
		
		//商品名
		private String productName;
		
		//商品の値段
		private Integer unitPrice;
		
		//残っている数
		private Integer unitsInStock;
		
		//商品の描写
		private String description;
		
		//サプライヤー
		private String manufacturer;

		public Integer getProductId() {
			return productId;
		}

		public void setProductId(Integer productId) {
			this.productId = productId;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(String categoryId) {
			this.categoryId = categoryId;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public Integer getUnitPrice() {
			return unitPrice;
		}

		public void setUnitPrice(Integer unitPrice) {
			this.unitPrice = unitPrice;
		}

		public Integer getUnitsInStock() {
			return unitsInStock;
		}

		public void setUnitsInStock(Integer unitsInStock) {
			this.unitsInStock = unitsInStock;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getManufacturer() {
			return manufacturer;
		}

		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}

}
