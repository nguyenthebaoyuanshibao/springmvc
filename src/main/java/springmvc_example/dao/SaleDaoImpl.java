package springmvc_example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	private SqlParameterSource getSqlParameterSource(String saleId, String userId, String productId, Integer price) {

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();

		if (saleId != null) {
			parameterSource.addValue("saleId", saleId);
		}
		if (userId != null) {
			parameterSource.addValue("userId", userId);
		}
		if (productId != null) {
			parameterSource.addValue("productId", productId);
		}
		if (price != null) {
			parameterSource.addValue("price", price);
		}
		
		return parameterSource;
	}

	private static final class SaleMapper implements RowMapper<Sale> {

		public Sale mapRow(ResultSet rs, int numRow) throws SQLException {
			Sale sale = new Sale();
			
			sale.setSaleId(rs.getString("sale_id"));
			sale.setUserId(rs.getString("user_id"));
			sale.setProductId(rs.getString("product_id"));
			sale.setPrice(rs.getInt("price"));
			
			return sale;
		}
	
	}
	@Override
	public void addSale(String saleId, String userId, String productId,Integer price) {
		String sql ="INSERT INTO sale(sale_id, user_id, product_id, price) VALUES(:saleId, :userId, :productId, :price) ";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(saleId, userId, productId, price));
	}

	@Override
	public void updateSale(String saleId) {
		// TODO Auto-generated method stub
		
	}

	

}



	