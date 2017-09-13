package springmvc_example.dao;

import springmvc_example.model.Sale;

public interface SaleDao {
	
	void addSale(String saleId, String userId, String productId, Integer price);
	
	void updateSale(String saleId);

}
