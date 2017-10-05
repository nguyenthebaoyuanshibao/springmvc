package springmvc_example.service;

import java.util.List;

import springmvc_example.model.Category;

public interface CategoryService {
	
		void deleteCategoryByCategoryId(Integer categoryId);
		
		public List<Category> listCategory();
		
		public void addCategory(String categoryName);
		
		public boolean existsCategory(String categoryName);
		
		public boolean canDeleteCategory(Integer CategoryId);
}
