package springmvc_example.form;

public class CategoryForm {
	
		//商品のカテゴリ
		private String categoryName;
		
		public String getCategoryName(){
			return categoryName;
		}
      
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
}
