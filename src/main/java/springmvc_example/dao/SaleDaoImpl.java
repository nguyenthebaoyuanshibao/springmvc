package springmvc_example.dao;

import org.springframework.stereotype.Repository;

import springmvc_example.model.Review;
import springmvc_example.model.Sale;

@Repository
public class SaleDaoImpl implements SaleDao {

	@Override
	public void addSale(String saleId, Integer userId, String productId, Integer price) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sale updateSale(String saleId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
