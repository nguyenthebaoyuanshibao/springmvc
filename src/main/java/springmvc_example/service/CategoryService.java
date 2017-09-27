package springmvc_example.service;

import java.util.List;

import springmvc_example.model.Category;

public interface CategoryService {
	
	void deleteCategory(String categoryId);
	public List<Category> listCategory();
}
