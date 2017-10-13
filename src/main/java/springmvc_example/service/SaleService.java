package springmvc_example.service;

import java.util.List;

import springmvc_example.model.Sale;

public interface SaleService {
	//Saleレコードを追加する。
		void addSale(Integer userId, Integer productId, Integer quantity, Integer price);
		
		//Saleレコードを変更する。
		void updateSale(Integer saleId);
		
		Sale getSaleBySaleId(Integer saleId);
		
		List<Sale> getSalesByUserId(Integer userId);
		
		// Get sale's record by productId.
		List<Sale> getSalesByProductId(Integer productId);
		
		void deleteSaleBySaleId(Integer saleId);
		
		//productId でSaleレコードを削除する。
		void deleteSalesByProductId(Integer productId);
		
		void deleteSalesByUserId(Integer userId);

}
