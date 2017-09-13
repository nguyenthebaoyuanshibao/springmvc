package springmvc_example.service;

import springmvc_example.model.Sale;

public interface SaleService {
	
	void addSale(String saleId, String userId, String productId, Integer price);

	void updateSale(String saleId);

}
