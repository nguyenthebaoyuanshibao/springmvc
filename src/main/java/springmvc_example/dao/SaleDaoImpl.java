package springmvc_example.dao;

import java.security.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import springmvc_example.model.Product;
import springmvc_example.model.Review;
import springmvc_example.model.Sale;

@Repository
public class SaleDaoImpl implements SaleDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	private SqlParameterSource getSqlParameterSource(String userId, Integer productId,
			Integer quantity, Integer price, Timestamp createAt, Timestamp updateAt) 
	{

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		
		if (userId != null) {
			parameterSource.addValue("userId", userId);
		}
		
		if (productId != null) {
			parameterSource.addValue("productId", productId);
		}
		
		if (quantity != null) {
			parameterSource.addValue("quantity", quantity);
		}
		
		if (price != null) {
			parameterSource.addValue("price", price);
		}

		return parameterSource;
	}

	private static final class SaleMapper implements RowMapper<Sale> {

		public Sale mapRow(ResultSet rs, int numRow) throws SQLException {
			
			Sale sale = new Sale();
			
			sale.setUserId(rs.getString("user_id"));
			sale.setProductId(rs.getString("product_id"));
			sale.setPrice(rs.getInt("price"));
			sale.setQuantity(rs.getInt("quantity"));
			
			return sale;
		}
	}
    
	//Saleレコードを追加する。
	@Override
	public void addSale(String userId, Integer productId, Integer quantity, Integer price) {
		
		String sql = "INSERT INTO sale(user_id, product_id, quantity, price, create_at, update_at) VALUES(:userId, :productId, :quantity, :price, now(), now())";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(userId, productId, quantity, price, null, null));
	}
    
	// Get sale's record by productId.
	@Override
	public List<Sale> getSaleByProductId(Integer productId) {
		
		String sql = "SELECT * FROM sale where product_id =:productId";
		List<Sale> sales = this.namedParameterJdbcTemplate.query(sql,
				getSqlParameterSource(null, productId, null, null, null, null), new SaleMapper());

		return sales;
	}
    
	//productId でSaleレコードを削除する。
	@Override
	public void deleteSaleByProductId(Integer productId) {

		String sql = "DELETE FROM sale where product_id =:productId";
		this.namedParameterJdbcTemplate.update(sql, getSqlParameterSource(null, productId, null, null, null, null));

	}
	
	//Saleレコードを変更する。
	@Override
	public void updateSale(Integer saleId) {
		// TODO Auto-generated method stub

	}

}
	