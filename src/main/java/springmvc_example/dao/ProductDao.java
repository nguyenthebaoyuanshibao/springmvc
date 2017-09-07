package springmvc_example.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import springmvc_example.model.Product;



/**
 * @author life
 *
 */
public interface ProductDao
{
	List<Product> getAllProducts();
	Product getProductById(String argProductId) ;
	List<Product> getProductsByCategory(String argCategory);
	Set<Product> getProductsByFilter(Map<String, List<String>> argFilterParams);
}
