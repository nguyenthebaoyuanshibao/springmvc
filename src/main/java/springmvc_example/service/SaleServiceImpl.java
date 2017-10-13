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
	public void addSale(Integer userId, Integer productId, Integer quantity, Integer price) {

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
	public List<Sale> getSalesByProductId(Integer productId) {
		return saleDao.getSalesByProductId(productId);
	}

	@Override
	public void deleteSalesByProductId(Integer productId) {

		saleDao.deleteSalesByProductId(productId);
	}

	@Override
	public void updateSale(Integer saleId) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteSalesByUserId(Integer userId) {
		
		saleDao.deleteSalesByUserId(userId);		
	}

	@Override
	public Sale getSaleBySaleId(Integer saleId) {
		
		return saleDao.getSaleBySaleId(saleId);
	}

	@Override
	public List<Sale> getSalesByUserId(Integer userId) {
		
		return saleDao.getSalesByUserId(userId);
	}

	@Override
	public void deleteSaleBySaleId(Integer saleId) {
		
		saleDao.deleteSaleBySaleId(saleId);	
	}
}
