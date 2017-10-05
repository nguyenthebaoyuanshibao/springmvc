package springmvc_example.dao;

import java.util.Date;
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

	List<Product> getProductBy(Integer categoryId, String productName, Integer priceFrom, Integer priceTo);

	List<Product> getProductByName(String productName);

	Product getProductByProductId(Integer productId);

	List<Product> getProductsByCategory(Integer categoryId);

	void addProduct(String url, Integer categoryId, String productName, Integer unitPrice, Integer unitsInStock,
			String description, String manufacturer);

	void deleteProductByProductId(Integer productId);

	void updateUnitsInStock(Integer productId, Integer unitsInStock);

	void updateProduct(Integer productId, String url, Integer categoryId, String productName, Integer unitPrice,
			Integer unitsInStock, String description, String manufacturer);

}
