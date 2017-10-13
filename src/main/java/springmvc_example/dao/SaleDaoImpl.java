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

	private SqlParameterSource getSqlParameterSource(Integer saleId, Integer userId, Integer productId,
			Integer quantity, Integer price, Timestamp createAt, Timestamp updateAt) 
	{

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if(saleId!=null) {
			parameterSource.addValue("saleId", saleId);
		}
		
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
			sale.setSaleId(rs.getInt("sale_id"));
			sale.setUserId(rs.getInt("user_id"));
			sale.setProductId(rs.getString("product_id"));
			sale.setPrice(rs.getInt("price"));
			sale.setQuantity(rs.getInt("quantity"));
			
			return sale;
		}
	}
    
	//Saleレコードを追加する。
	@Override
	public void addSale(Integer userId, Integer productId, Integer quantity, Integer price) {
		
		String sql = "INSERT INTO sale(user_id, product_id, quantity, price, create_at, update_at) VALUES(:userId, :productId, :quantity, :price, now(), now())";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(null,userId, productId, quantity, price, null, null));
	}
    
	// Get sale's record by productId.
	@Override
	public List<Sale> getSalesByProductId(Integer productId) {
		
		String sql = "SELECT * FROM sale where product_id =:productId";
		List<Sale> sales = this.namedParameterJdbcTemplate.query(sql,
				getSqlParameterSource(null,null, productId, null, null, null, null), new SaleMapper());

		return sales;
	}
    
	//productId でSaleレコードを削除する。
	@Override
	public void deleteSalesByProductId(Integer productId) {

		String sql = "DELETE FROM sale where product_id =:productId";
		this.namedParameterJdbcTemplate.update(sql, getSqlParameterSource(null, null, productId, null, null, null, null));

	}
	
	//Saleレコードを変更する。
	@Override
	public void updateSale(Integer saleId) {

	}

	@Override
	public void deleteSalesByUserId(Integer userId) {
		
		String sql ="delete from sale where user_id =:userId";
		this.namedParameterJdbcTemplate.update(sql, getSqlParameterSource(null, userId, null, null, null, null, null));
	}

	@Override
	public Sale getSaleBySaleId(Integer saleId) {
		
		String sql="select * from sale where sale_id :=saleId";
		Sale sale = namedParameterJdbcTemplate.queryForObject(sql,
				this.getSqlParameterSource(saleId, null, null, null, null, null, null), new SaleMapper()); 
		return sale;
	}

	@Override
	public List<Sale> getSalesByUserId(Integer userId) {
		
		String sql = "SELECT * FROM sale where user_id =:userId";
		List<Sale> sales = this.namedParameterJdbcTemplate.query(sql,
				getSqlParameterSource(null, userId, null, null, null, null, null), new SaleMapper());

		return sales;
	}

	@Override
	public void deleteSaleBySaleId(Integer saleId) {
		
		String sql = "delete from sale where sale_id :=saleId";
		this.namedParameterJdbcTemplate.update(sql, this.getSqlParameterSource(saleId, null, null, null, null, null, null));		
	}

}
	