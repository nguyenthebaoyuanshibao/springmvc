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
	
	/* (non-Javadoc)
	 * @see com.packt.webstore.service.OrderService#getAllProducts()
	 */
	@Override
	public List<Product> getAllProducts()
	{
		return this.productRepository.getAllProducts();
	}

	/* (non-Javadoc)
	 * @see com.packt.webstore.service.ProductService#getProductById(java.lang.String)
	 */
	@Override
	public Product getProductById(String argProductId)
	{
		return this.productRepository.getProductById(argProductId);
	}

	/* (non-Javadoc)
	 * @see com.packt.webstore.service.ProductService#getProductsByCategory(java.lang.String)
	 */
	@Override
	public List<Product> getProductsByCategory(String argCategory)
	{
		return this.productRepository.getProductsByCategory(argCategory);
	}

	/* (non-Javadoc)
	 * @see com.packt.webstore.service.ProductService#getProductsByFilter(java.util.Map)
	 */
	@Override
	public Set<Product> getProductsByFilter(Map<String, List<String>> argFilterParams)
	{
		return this.productRepository.getProductsByFilter(argFilterParams);
	}
}
