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
		String sql = "SELECT * FROM products";
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
		    product.setUnitPrice(rs.getInt("unit_price"));
			product.setUnitsInStock(rs.getInt("units_in_stock"));
			product.setManufacturer(rs.getString("manufacturer"));
			product.setCategoryId(rs.getString("category_id"));
			
			return product;
		}
	}

	@Override
	public Product getProductById(String productId) {
		
		String sql = "SELECT * FROM products where product_id= :productId";
		List<Product> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(productId,null), new ProductMapper());
		if(list.size()<1) {
			return new Product();
		}
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

	

}
