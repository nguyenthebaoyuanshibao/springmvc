package springmvc_example.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc_example.dao.ProductDao;
import springmvc_example.model.Product;


/**
 * @author life
 *
 */
@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductDao productRepository; 
	
	@Override
	public List<Product> getAllProducts()
	{
		return this.productRepository.getAllProducts();
	}


	@Override
	public List<Product> getProductByName(String productName) {
		return this.productRepository.getProductByName(productName);
	}

	
	@Override
	public List<Product> getProductsByCategory(String argCategory)
	{
		return this.productRepository.getProductsByCategory(argCategory);
	}

	@Override
	public List<Product> search(String categoryId, Integer priceFrom, Integer priceTo, String productName) {
		
		return this.productRepository.search(categoryId, priceFrom, priceTo, productName);
	}


	@Override
	public void addProduct(String productId, String categoryId, String productName, Integer unitPrice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProductById(String productId) {
		// TODO Auto-generated method stub
		
	}



	


	
	
}
