package springmvc_example.dao;

import springmvc_example.model.Sale;

public interface SaleDao {
	
	void addSale(String saleId, Integer userId, String saleInfo, Integer price);
	
	Sale updateSale(String saleId);

}