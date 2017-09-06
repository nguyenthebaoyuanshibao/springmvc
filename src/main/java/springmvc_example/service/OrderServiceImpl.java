package springmvc_example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc_example.dao.ProductDao;
import springmvc_example.model.Product;


/**
 * @author life
 *
 */
@Service
public class OrderServiceImpl implements OrderService
{
	@Autowired
	private ProductDao productRepository;   
	
	/* (non-Javadoc)
	 * @see com.packt.webstore.service.OrderService#processOrder(java.lang.String, java.lang.Integer)
	 */
	@Override
	public void processOrder(String argProductId, Integer argCount)
	{
		Product productById = this.productRepository.getProductById(argProductId);

		if (productById.getUnitsInStock() < argCount)
		{
			throw new IllegalArgumentException(
					"Out of Stock. Available Units in stock"
							+ productById.getUnitsInStock());
		}

		productById.setUnitsInStock(productById.getUnitsInStock() - argCount);
	}
}
