package springmvc_example.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import springmvc_example.model.Product;



/**
 * @author life
 *
 */
public interface ProductService
{
	List<Product> getAllProducts();
	void addProduct(String productId, String categoryId, String productName, Integer unitPrice);
	void deleteProductById(String productId);
	List<Product> search(String categoryId, Integer priceFrom, Integer priceTo,String productName);
	List<Product> getProductByName(String productName) ;
	List<Product> getProductsByCategory(String argCategory);
}
