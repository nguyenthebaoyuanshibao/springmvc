package springmvc_example.service;

import springmvc_example.model.Sale;

public interface SaleService {
	
	void addSale(String userId, Integer productId, Integer quantity, Integer price);

	void updateSale(Integer saleId);

}
