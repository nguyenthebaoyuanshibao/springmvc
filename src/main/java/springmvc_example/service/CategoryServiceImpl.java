package springmvc_example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc_example.dao.CategoryDao;
import springmvc_example.dao.ProductDao;
import springmvc_example.dao.ReviewDao;
import springmvc_example.dao.SaleDao;
import springmvc_example.model.Product;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private SaleDao saleDao;

	@Autowired
	private ReviewDao reviewDao;

	// Delete Category By Category ID.
	@Override
	public void deleteCategory(String categoryId) {

		List<Product> products = productDao.getProductsByCategory(categoryId);

		for (Product product : products) {

			Integer productId = product.getProductId();

			saleDao.deleteSaleByProductId(productId);
			reviewDao.deleteReviewByProductId(productId);
			productDao.deleteProductByProductId(productId);
		}

		categoryDao.deleteCategory(categoryId);
	}

}
