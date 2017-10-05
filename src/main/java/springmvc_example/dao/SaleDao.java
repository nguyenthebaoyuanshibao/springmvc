package springmvc_example.dao;

import java.util.List;

import springmvc_example.model.Sale;

public interface SaleDao {
	
	//Saleレコードを追加する。
	void addSale(Integer userId, Integer productId, Integer quantity, Integer price);
	
	//Saleレコードを変更する。
	void updateSale(Integer saleId);
	
	// Get sale's record by productId.
	List<Sale> getSaleByProductId(Integer productId);
	
	//productId でSaleレコードを削除する。
	void deleteSaleByProductId(Integer productId);
	
	void deleteSaleByUserId(Integer userId);

}
