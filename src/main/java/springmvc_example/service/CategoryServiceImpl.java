package springmvc_example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc_example.dao.CategoryDao;
import springmvc_example.dao.ProductDao;
import springmvc_example.dao.ReviewDao;
import springmvc_example.dao.SaleDao;
import springmvc_example.model.Category;
import springmvc_example.model.Product;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ProductDao productDao;

	// Delete Category By Category ID.
	@Override
	public void deleteCategoryByCategoryId(Integer categoryId) {

        if(canDeleteCategory(categoryId)) {
        	
		categoryDao.deleteCategoryByCategoryId(categoryId);
        }
	}

	@Override
	public List<Category> listCategory() {
		
		return this.categoryDao.listCategory();	
	}

	@Override
	public void addCategory(String categoryName) {
		
		if(!categoryDao.existsCategory(categoryName)) {
			
		categoryDao.addCategory(categoryName);
		}
	}

	@Override
	public boolean existsCategory(String categoryName) {
		return this.categoryDao.existsCategory(categoryName);
	}

	@Override
	public boolean canDeleteCategory(Integer categoryId) {
		
		List<Product> products = productDao.getProductsByCategory(categoryId);
		if(products.size()==0) {
			
			return true;
		}
		return false;
	}

}
