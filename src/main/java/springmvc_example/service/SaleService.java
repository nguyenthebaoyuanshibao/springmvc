package springmvc_example.service;

import java.util.List;

import springmvc_example.model.Sale;

public interface SaleService {
	
	void addSale(String userId, Integer productId, Integer quantity, Integer price);

	void updateSale(Integer saleId);
	
	List<Sale> getSaleByProductId(Integer productId);
	
	void deleteSaleByProductId(Integer productId);

}
