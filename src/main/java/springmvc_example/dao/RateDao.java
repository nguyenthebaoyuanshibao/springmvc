package springmvc_example.dao;

import springmvc_example.model.Product;

public interface RateDao {
	
	public void ratingAction(Product productId, Integer ratingNumber);

}
