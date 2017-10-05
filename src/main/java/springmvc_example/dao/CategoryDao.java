package springmvc_example.dao;
import java.util.List;

import springmvc_example.model.Category;

public interface CategoryDao {
	
	//Delete Catgory By Category ID.
	void deleteCategoryByCategoryId(Integer categoryId);
	
	public List<Category> listCategory();
	
	public void addCategory(String categoryName);
	
	public boolean existsCategory(String categoryName);
	
}
