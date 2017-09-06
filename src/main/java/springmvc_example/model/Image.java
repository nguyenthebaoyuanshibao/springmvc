package springmvc_example.model;

import java.util.Date;

public class Image {
	
	// 写真のID
		private String imageId;

		private String productId;

		// 写真
		private String url;

		// 作成日
		private Date createAt;

		// 更新日
		private Date updateAt;

		

		/* Construction */
		public Image() {

		}



		public Image(String imageId, String productId, String url, Date createAt, Date updateAt) {
			super();
			this.imageId = imageId;
			this.productId = productId;
			this.url = url;
			this.createAt = createAt;
			this.updateAt = updateAt;
		}



		public String getImageId() {
			return imageId;
		}



		public void setImageId(String imageId) {
			this.imageId = imageId;
		}



		public String getProductId() {
			return productId;
		}



		public void setProductId(String productId) {
			this.productId = productId;
		}



		public String getUrl() {
			return url;
		}



		public void setUrl(String url) {
			this.url = url;
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
