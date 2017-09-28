package springmvc_example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc_example.dao.ProductDao;
import springmvc_example.dao.SaleDao;
import springmvc_example.model.Product;
import springmvc_example.model.Sale;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private ProductDao productRepository;

	@Autowired
	private SaleDao saleDao;

	// Add sale.
	@Override
	public void addSale(String userId, Integer productId, Integer quantity, Integer price) {

		Product product = this.productRepository.getProductByProductId(productId);

		if (checkQuantity(productId, quantity)) {
			if(quantity<0){
				quantity=0;
			}

			product.setUnitsInStock(product.getUnitsInStock() - quantity);

			this.saleDao.addSale(userId, productId, quantity, price);
			this.productRepository.updateUnitsInStock(productId, product.getUnitsInStock());
		}
	}

	// check if products in stock is enought for order?
	public boolean checkQuantity(Integer productId, Integer quantity) {

		Product product = this.productRepository.getProductByProductId(productId);

		if (product.getUnitsInStock() >= quantity) {

			return true;
		}
		return false;
	}

	@Override
	public List<Sale> getSaleByProductId(Integer productId) {
		return saleDao.getSaleByProductId(productId);
	}

	@Override
	public void deleteSaleByProductId(Integer productId) {

		saleDao.deleteSaleByProductId(productId);
	}

	@Override
	public void updateSale(Integer saleId) {
		// TODO Auto-generated method stub

	}

}
