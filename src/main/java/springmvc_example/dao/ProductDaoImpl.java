package springmvc_example.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;


import springmvc_example.model.Product;
import springmvc_example.model.UserInfo;

/**
 * @author life
 *
 */
@Repository
public class ProductDaoImpl implements ProductDao {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<Product> getAllProducts() {
		String sql = "SELECT * from products";
		List<Product> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(null, null), new ProductMapper());
		
		return list;
	}
	
    
	private SqlParameterSource getSqlParameterSource(String productId, String categoryId) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if(productId!=null) {
			parameterSource.addValue("productId", productId);
		}
		if(categoryId!=null) {
			parameterSource.addValue("categoryId", categoryId);
		}
		return parameterSource;
	}
	
	private static final class ProductMapper implements RowMapper<Product>{
		
		public Product mapRow(ResultSet rs, int numRow) throws SQLException{
			Product product = new Product();
			product.setProductId(rs.getString("product_id"));
			product.setProductName(rs.getString("product_name"));
			product.setDescription(rs.getString("description"));
			
			
			
			return product;
		}
	}

	@Override
	public Product getProductById(String productId) {
		
		String sql = "SELECT * FROM products where product_id= :productId";
		List<Product> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(productId,null), new ProductMapper());
		
	
		return list.get(0);
	}

	@Override
	public List<Product> getProductsByCategory(String categoryId) {
		String sql = "SELECT * FROM products where category_id= :categoryId";
		List<Product> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(null,categoryId), new ProductMapper());
		
	
		return list;
	}

	@Override
	public Set<Product> getProductsByFilter(Map<String, List<String>> argFilterParams) {
		// TODO Auto-generated method stub
		return null;
	}

	// private List<Product> listOfProducts = new ArrayList<Product>();
	//
	// /**
	// * default items in product list
	// */
	// public ProductDaoImpl ()
	// {
	// Product iphone = new Product("P1234","iPhone 5s", new BigDecimal(500));
	// iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136
	// display and 8-megapixel rear camera");
	// iphone.setCategoryId("Smart Phone");
	// iphone.setManufacturer("Apple");
	// iphone.setUnitsInStock(8);
	//
	// Product laptop_dell = new Product("P1235","Dell Inspiron", new
	// BigDecimal(700));
	// laptop_dell.setDescription("Dell Inspiron 14-inch Laptop (Black) with 3rd
	// Generation Intel Core processors");
	// laptop_dell.setCategoryId("Laptop");
	// laptop_dell.setManufacturer("Dell");
	// laptop_dell.setUnitsInStock(1000);
	//
	// Product tablet_Nexus = new Product("P1236","Nexus 7", new BigDecimal(300));
	// tablet_Nexus.setDescription("Google Nexus 7 is the lightest 7 inch tablet
	// With a quad-core Qualcomm Snapdragon™ S4 Pro processor");
	// tablet_Nexus.setCategoryId("Tablet");
	// tablet_Nexus.setManufacturer("Google");
	// tablet_Nexus.setUnitsInStock(1000);
	//
	// this.listOfProducts.add(iphone);
	// this.listOfProducts.add(laptop_dell);
	// this.listOfProducts.add(tablet_Nexus);
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.packt.webstore.domain.repository.ProductRepository#getAllProducts()
	// */
	// @Override
	// public List<Product> getAllProducts()
	// {
	// return this.listOfProducts;
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.packt.webstore.domain.repository.ProductRepository#getProductById(java.lang.String)
	// */
	// @Override
	// public Product getProductById(String argProductId)
	// {
	// Product productById = null;
	//
	// for (Product product : this.listOfProducts)
	// {
	// if (product != null && product.getProductId() != null &&
	// product.getProductId().equals(argProductId))
	// {
	// productById = product;
	// break;
	// }
	// }
	//
	// if(productById == null)
	// {
	// throw new IllegalArgumentException("No products found with the product id: "
	// + argProductId);
	// }
	//
	// return productById;
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.packt.webstore.domain.repository.ProductRepository#getProductsByCategory(java.lang.String)
	// */
	// @Override
	// public List<Product> getProductsByCategory(String argCategory)
	// {
	// List<Product> productsByCategory = new ArrayList<Product>();
	//
	// for (Product product : this.listOfProducts)
	// {
	// if(argCategory.equalsIgnoreCase(product.getCategoryId()))
	// {
	// productsByCategory.add(product);
	// }
	// }
	//
	// return productsByCategory;
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.packt.webstore.domain.repository.ProductRepository#getProductsByFilter(java.util.Map)
	// */
	// @Override
	// public Set<Product> getProductsByFilter(Map<String, List<String>>
	// argFilterParams)
	// {
	// Set<Product> productsByBrand = new HashSet<Product>();
	// Set<Product> productsByCategory = new HashSet<Product>();
	//
	// Set<String> criterias = argFilterParams.keySet();
	//
	// if (criterias.contains("brand"))
	// {
	// for (String brandName : argFilterParams.get("brand"))
	// {
	// for (Product product : this.listOfProducts)
	// {
	// if (brandName.equalsIgnoreCase(product.getManufacturer()))
	// {
	// productsByBrand.add(product);
	// }
	// }
	// }
	// }
	//
	// if (criterias.contains("category"))
	// {
	// for (String category : argFilterParams.get("category"))
	// {
	// productsByCategory.addAll(this.getProductsByCategory(category));
	// }
	// }
	//
	// productsByCategory.retainAll(productsByBrand);
	//
	// return productsByCategory;
	// }

}
