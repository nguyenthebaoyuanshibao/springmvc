package springmvc_example.dao;

import java.math.BigDecimal;
import java.security.Timestamp;
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

	private SqlParameterSource getSqlParameterSource(Integer productId, String url, String categoryId,
			String productName, Integer unitPrice, Integer unitsInStock, 
			String description, String manufacturer, Timestamp createAt, Timestamp updateAt) {

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();

		if (productId != null) {
			parameterSource.addValue("productId", productId);
		}

		if (url != null) {
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

		if (unitsInStock != null) {
			parameterSource.addValue("unitsInStock", unitsInStock);
		}

		if (description != null) {
			parameterSource.addValue("description", description);
		}

		if (manufacturer != null) {
			parameterSource.addValue("manufacturer", manufacturer);
		}
		
	    parameterSource.addValue("priceFrom", 0);

		parameterSource.addValue("priceTo", 700);

		return parameterSource;
	}

	private static final class ProductMapper implements RowMapper<Product> {

		public Product mapRow(ResultSet rs, int numRow) throws SQLException {

			Product product = new Product();

			product.setProductId(rs.getInt("product_id"));
			product.setUrl(rs.getString("url"));
			product.setProductName(rs.getString("product_name"));
			product.setDescription(rs.getString("description"));
			product.setUnitPrice(rs.getInt("unit_price"));
			product.setUnitsInStock(rs.getInt("units_in_stock"));
			product.setManufacturer(rs.getString("manufacturer"));
			product.setCategoryId(rs.getString("category_id"));
            product.setUpdateAt(rs.getTimestamp("update_at"));
            product.setCreateAt(rs.getTimestamp("create_at"));
            
			return product;
		}
	}
    
	// Get All Products.
	@Override
	public List<Product> getAllProducts() {

		String sql = "SELECT * FROM products";
		List<Product> list = namedParameterJdbcTemplate.query(sql,
				getSqlParameterSource(null, null, null, null, null, null, null, null, null, null), new ProductMapper());

		return list;
	}
    
	// Get Product By Product Name.
	@Override
	public List<Product> getProductByName(String productName) {

		String sql = "SELECT * FROM products where product_name= :productName";
		List<Product> list = namedParameterJdbcTemplate.query(sql,
				getSqlParameterSource(null, null, null, productName, null, null, null, null, null, null), new ProductMapper());

		return list;
	}
    
	// Get Product By Product ID.
	@Override
	public Product getProductByProductId(Integer productId) {

		String sql = "SELECT * FROM products where product_id= :productId";
		Product product = namedParameterJdbcTemplate.queryForObject(sql,
				getSqlParameterSource(productId, null, null, null, null, null, null, null, null, null), new ProductMapper());

		return product;
	}
    
	// Get Product By Many Params.
	@Override
	public List<Product> getProductBy(String categoryId, Integer priceFrom, Integer priceTo, String productName) {

		if (categoryId == null || categoryId == "") {

			String sql = "SELECT * from products WHERE product_name LIKE '%" + productName
					+ "%' AND unit_price >= :priceFrom AND unit_price <= :priceTo ORDER BY product_id ";

			List<Product> list = namedParameterJdbcTemplate.query(sql,
					getSqlParameterSource(null, null, categoryId, productName, null, null, null, null, null, null),
					new ProductMapper());

			return list;

		} else {

			String sql = "SELECT * from products WHERE product_name LIKE '%" + productName
					+ "%' AND category_id =:categoryId AND unit_price >= :priceFrom "
					+ "AND unit_price <= :priceTo ORDER BY product_id ";

			List<Product> list = namedParameterJdbcTemplate.query(sql,
					getSqlParameterSource(null, null, categoryId, productName, null, null, null, null, null, null),
					new ProductMapper());

			return list;
		}
	}
    
	// Get Product By Category ID.
	@Override
	public List<Product> getProductsByCategory(String categoryId) {

		String sql = "SELECT * FROM products where category_id= :categoryId";
		List<Product> list = namedParameterJdbcTemplate.query(sql,
				getSqlParameterSource(null, null, categoryId, null, null, null, null, null, null, null), new ProductMapper());

		return list;
	}

	@Override
	public void updateUnitsInStock(Integer productId, Integer unitsInStock) {

		String sql = "update products set units_in_stock =:unitsInStock, update_at = now() where product_id= :productId";

		namedParameterJdbcTemplate.update(sql,
				getSqlParameterSource(productId, null, null, null, null, unitsInStock, null, null, null, null));
	}
    
	// Add Product.
	@Override
	public void addProduct(String url, String categoryId, String productName, Integer unitPrice, Integer unitsInStock,
			String description, String manufacturer) {
		
		String sql = "INSERT INTO products(url, category_id, product_name, unit_price, units_in_stock, description, manufacturer, create_at, update_at) "
				+ "VALUES(:url, :categoryId, :productName, :unitPrice, :unitsInStock, :description, :manufacturer, now(), now())";

		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(null, url, categoryId, productName, unitPrice,
				unitsInStock, description, manufacturer, null, null));
	}
    
	// Delete Product By Product ID.
	@Override
	public void deleteProductByProductId(Integer productId) {

		String sql = "DELETE FROM products where product_id =:productId";

		this.namedParameterJdbcTemplate.update(sql,
				this.getSqlParameterSource(productId, null, null, null, null, null, null, null, null, null));

	}
    
	// Update Product Information.
	@Override
	public void updateProduct(Integer productId, String url, String categoryId, String productName, Integer unitPrice,
			Integer unitsInStock, String description, String manufacturer) {

		String sql = "update products set url =:url, category_id =:categoryId, product_name =:productName, "
				+ " unit_price =:unitPrice, units_in_stock =:unitsInStock, description =:description,"
				+ "manufacturer =:manufacturer, update_at = now() where product_id =:productId ";

		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(productId, url, categoryId, productName, unitPrice,
				unitsInStock, description, manufacturer, null, null));
	}

}
