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
	Product getProductById(String argProductId);
	List<Product> getProductsByCategory(String categoryId);
	Set<Product> getProductsByFilter(Map<String, List<String>> argFilterParams);
}
