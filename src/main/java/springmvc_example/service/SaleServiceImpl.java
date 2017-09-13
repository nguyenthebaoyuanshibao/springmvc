package springmvc_example.service;

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
	
	@Override
	public void addSale(String saleId, String userId, String productId, Integer price) {
		
		Product product = this.productRepository.getProductById(productId);
		Integer unitPrice = product.getUnitPrice();
		if(checkQuantity(productId, price/unitPrice)){
			
			 product.setUnitsInStock(product.getUnitsInStock()-price/unitPrice);
			 
			 this.saleDao.addSale(saleId, userId, productId, price);
			 this.productRepository.updateUnitsInStock(productId, product.getUnitsInStock());
		}
		

	}

	@Override
	public void updateSale(String saleId) {
		// TODO Auto-generated method stub
	
	}
	
	public boolean checkQuantity(String productId, Integer quantity ){
    	Product product = this.productRepository.getProductById(productId);
    	if(product.getUnitsInStock()>=quantity){
    		
    		return true;
    	}
    	return false;
    }

}
