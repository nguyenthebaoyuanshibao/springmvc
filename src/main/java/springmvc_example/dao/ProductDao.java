package springmvc_example.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import springmvc_example.model.Product;
import springmvc_example.model.Sale;



/**
 * @author life
 *
 */
public interface ProductDao {

	List<Product> getAllProducts();

	List<Product> getProductBy(String categoryId, Integer priceFrom, Integer priceTo, String productName);

	List<Product> getProductByName(String productName);

	Product getProductByProductId(Integer productId);

	List<Product> getProductsByCategory(String categoryId);

	void addProduct(String url, String categoryId, String productName, Integer unitPrice, Integer unitsInStock,
			String description, String manufacturer);

	void deleteProductByProductId(Integer productId);

	void updateUnitsInStock(Integer productId, Integer unitsInStock);

	void updateProduct(Integer productId, String url, String categoryId, String productName, Integer unitPrice,
			Integer unitsInStock, String description, String manufacturer);

}
