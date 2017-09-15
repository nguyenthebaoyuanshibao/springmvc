package springmvc_example.dao;

import springmvc_example.model.Sale;

public interface SaleDao {
	
	void addSale(String userId, Integer productId, Integer quantity, Integer price);
	
	void updateSale(Integer saleId);

}
