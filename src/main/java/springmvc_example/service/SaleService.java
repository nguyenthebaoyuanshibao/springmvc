package springmvc_example.service;

import springmvc_example.model.Sale;

public interface SaleService {
	
	void addSale(String saleId, Integer userId, String saleInfo, Integer price);

	Sale updateSale(String saleId);

}
