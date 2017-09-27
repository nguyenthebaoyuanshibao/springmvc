package springmvc_example.dao;
import java.util.List;

import springmvc_example.model.Category;

public interface CategoryDao {
	
	//Delete Catgory By Category ID.
	void deleteCategory(String categoryId);
	
	public List<Category> listCategory();
}
