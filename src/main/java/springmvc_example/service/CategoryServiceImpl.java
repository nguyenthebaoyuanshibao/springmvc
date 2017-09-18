package springmvc_example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc_example.dao.CategoryDao;
import springmvc_example.dao.ProductDao;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao; 
	
    @Autowired 
    private ProductDao productDao;
    
    
    
	@Override
	public void deleteCategory(String categoryId) {
	
		this.categoryDao.deleteCategory(categoryId);
		

	}

}
