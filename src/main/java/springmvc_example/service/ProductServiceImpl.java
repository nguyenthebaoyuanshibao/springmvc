package springmvc_example.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc_example.dao.ProductDao;
import springmvc_example.dao.ReviewDao;
import springmvc_example.dao.SaleDao;
import springmvc_example.model.Product;
import springmvc_example.model.Sale;

/**
 * @author life
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ReviewDao reviewDao;
	@Autowired
	private SaleDao saleDao;

	// Get All Product.
	@Override
	public List<Product> getAllProducts() {
		
		return this.productDao.getAllProducts();
	}

	// Get Product By Name.
	@Override
	public List<Product> getProductByName(String productName) {
		
		return this.productDao.getProductByName(productName);
	}

	// Get Product By Product ID.
	@Override
	public Product getProductByProductId(Integer productId) {
		
		return this.productDao.getProductByProductId(productId);
	}

	// Get Product By Category.
	@Override
	public List<Product> getProductsByCategory(Integer categoryId) {
		
		return this.productDao.getProductsByCategory(categoryId);
	}

	// Get Product By Many Params.
	@Override
	public List<Product> getProductBy(Integer categoryId, String productName, Integer priceFrom, Integer priceTo) {

		return this.productDao.getProductBy(categoryId, productName, priceFrom, priceTo);
	}

	// Update Units In Stock.
	@Override
	public void updateUnitsInStock(Integer productId, Integer unitsInStock) {

		this.productDao.updateUnitsInStock(productId, unitsInStock);

	}

	// Add Product.
	@Override
	public void addProduct(String url, Integer categoryId, String productName, Integer unitPrice, Integer unitsInStock,
			String description, String manufacturer) {

		this.productDao.addProduct(url, categoryId, productName, unitPrice, unitsInStock, description, manufacturer);

	}

	// Update Product Information.
	@Override
	public void updateProduct(Integer productId, String url, Integer categoryId, String productName, Integer unitPrice,
			Integer unitsInStock, String description, String manufacturer) {
		
		this.productDao.updateProduct(productId, url, categoryId, productName, unitPrice, unitsInStock, description,
				manufacturer);
		

	}

	// Delete Product By Product ID.
	@Override
	public void deleteProductByProductId(Integer productId) {
		
		saleDao.deleteSalesByProductId(productId);
		reviewDao.deleteReviewByProductId(productId);
		this.productDao.deleteProductByProductId(productId);

	}
}
