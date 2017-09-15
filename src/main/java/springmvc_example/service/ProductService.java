package springmvc_example.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import springmvc_example.model.Product;
import springmvc_example.model.Sale;



/**
 * @author life
 *
 */
public interface ProductService
{
	List<Product> getAllProducts();
	
	void addProduct(String url,String categoryId, 
			String productName, Integer unitPrice, Integer unitsInStock, 
			String description, String manufacturer);
	
	void deleteProductById(Integer productId);
	
	List<Product> search(String categoryId, Integer priceFrom, Integer priceTo, String productName);
	
	List<Product> getProductByName(String productName) ;
	
	List<Product> getProductsByCategory(String categoryId);
	
	Product getProductById(Integer productId);
	
	void updateUnitsInStock(Integer productId, Integer unitsInStock);
	
	void updateProduct(Integer productId, String url,String categoryId, String productName, Integer unitPrice,
			Integer unitsInStock, String description, String manufacturer);
}
