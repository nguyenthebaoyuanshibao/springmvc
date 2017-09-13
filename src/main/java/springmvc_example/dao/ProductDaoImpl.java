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
import springmvc_example.model.Sale;

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
		String sql = "SELECT * FROM products";
		List<Product> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(null,null,null, null, null,null),
				new ProductMapper());

		return list;
	}

	private SqlParameterSource getSqlParameterSource(String productId, String url, String categoryId,String productName, Integer unitPrice, Integer unitsInStock) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (productId!=null){
			parameterSource.addValue("productId", productId);
		}
		if(url!=null) {
			parameterSource.addValue("url", url);
		}
		if (categoryId != null) {
			parameterSource.addValue("categoryId", categoryId);
		}
		if (productName != null) {
			parameterSource.addValue("productName", productName);
		}
		if (unitPrice != null) {
			parameterSource.addValue("unitPrice", unitPrice);
		}
		if(unitsInStock!=null) {
			parameterSource.addValue("unitsInStock", unitsInStock);
		}

		parameterSource.addValue("priceFrom", 0);
		parameterSource.addValue("priceTo", 450);
		

		return parameterSource;
	}

	private static final class ProductMapper implements RowMapper<Product> {

		public Product mapRow(ResultSet rs, int numRow) throws SQLException {
			Product product = new Product();
			product.setProductId(rs.getString("product_id"));
			product.setUrl(rs.getString("url"));
			product.setProductName(rs.getString("product_name"));
			product.setDescription(rs.getString("description"));
			product.setUnitPrice(rs.getInt("unit_price"));
			product.setUnitsInStock(rs.getInt("units_in_stock"));
			product.setManufacturer(rs.getString("manufacturer"));
			product.setCategoryId(rs.getString("category_id"));

			return product;
		}
	}

	@Override
	public List<Product> getProductByName(String productName) {
		String sql = "SELECT * FROM products where product_name= :productName";
		List<Product> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(null,null,null,productName, null,null),
				new ProductMapper());

		return list;
	}
	@Override
	public Product getProductById(String productId) {
		String sql = "SELECT * FROM products where product_id= :productId";
		Product product = namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterSource(productId,null,null, null, null,null),
				new ProductMapper());

		return product;
	}

	@Override
	public List<Product> search(String categoryId, Integer priceFrom, Integer priceTo, String productName) {

		if (categoryId == null || categoryId == "") {
			String sql = "SELECT * from products WHERE product_name LIKE '%" + productName
					+ "%' AND unit_price >= :priceFrom AND unit_price <= :priceTo ORDER BY product_id ";
			List<Product> list = namedParameterJdbcTemplate.query(sql,
					getSqlParameterSource(null,null,categoryId,productName, null,null), new ProductMapper());
			return list;
		} else {
			String sql = "SELECT * from products WHERE product_name LIKE '%" + productName
					+ "%' AND category_id =:categoryId AND unit_price >= :priceFrom AND unit_price <= :priceTo ORDER BY product_id ";

			List<Product> list = namedParameterJdbcTemplate.query(sql,
					getSqlParameterSource(null,null,categoryId,productName, null,null), new ProductMapper());
			return list;
		}
	}

	@Override
	public List<Product> getProductsByCategory(String categoryId) {
		String sql = "SELECT * FROM products where category_id= :categoryId";
		List<Product> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(null,null, categoryId,null, null,null),
				new ProductMapper());

		return list;
	}
	
	@Override
	public void updateUnitsInStock(String productId, Integer unitsInStock) {
		String sql = "update products set units_in_stock =:unitsInStock where product_id= :productId";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(productId,null, null, null, null,unitsInStock));
		
	}


	@Override
	public void addProduct(String productId, String url,String categoryId, String productName, Integer unitPrice, Integer unitsInStock) {
		String sql = "INSERT INTO products(product_id, url, category_id, product_name, unit_price, units_in_stock) "
				+ "VALUES(:productId, :url, :categoryId, :productName, :unitPrice, :unitsInStock)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(productId,url,categoryId,productName,unitPrice,unitsInStock));
	}

	@Override
	public void deleteProductById(String productId) {
		// TODO Auto-generated method stub

	}



	

}
