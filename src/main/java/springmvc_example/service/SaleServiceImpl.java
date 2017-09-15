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
	public void addSale(String userId, Integer productId, Integer quantity, Integer price) {
		
		Product product = this.productRepository.getProductById(productId);
		
		if(checkQuantity(productId, quantity)){
			
			 product.setUnitsInStock(product.getUnitsInStock()-quantity);
			 
			 this.saleDao.addSale(userId, productId,quantity, price);
			 this.productRepository.updateUnitsInStock(productId, product.getUnitsInStock());
		}
		

	}
	
	public boolean checkQuantity(Integer productId, Integer quantity ){
    	Product product = this.productRepository.getProductById(productId);
    	if(product.getUnitsInStock()>=quantity){
    		
    		return true;
    	}
    	return false;
    }
	
	@Override
	public void updateSale(Integer saleId) {
		// TODO Auto-generated method stub
	
	}

}
