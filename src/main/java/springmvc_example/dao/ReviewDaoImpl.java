package springmvc_example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import springmvc_example.model.Product;
import springmvc_example.model.Review;

@Repository
public class ReviewDaoImpl implements ReviewDao {
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	private SqlParameterSource getSqlParameterSource(Integer reviewId, Integer userId, Integer productId,
			            String reviewInfo,  Integer ratingNumber, Timestamp createAt, Timestamp updateAt) {
		
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		
	    if(reviewId!=null) {
	    	parameterSource.addValue("reviewId", reviewId);
	    }
	    
	    if(userId!=null) {
	    	parameterSource.addValue("userId", userId);
	    }
	    
	    if(productId!=null) {
	    	parameterSource.addValue("productId", productId);
	    }
	    
	    if(reviewInfo!=null) {
	    	parameterSource.addValue("reviewInfo", reviewInfo);
	    }
	    
	    if(ratingNumber!=null) {
	    	parameterSource.addValue("ratingNumber", ratingNumber);
	    }
	    
		return parameterSource;
	}
	
	private static final class ReviewMapper implements RowMapper<Review> {

		public Review mapRow(ResultSet rs, int numRow) throws SQLException {
			
			Review review = new Review();
			review.setReviewId(rs.getInt("review_id"));
			review.setUserId(rs.getInt("user_id"));
			review.setProductId(rs.getInt("product_id"));
			review.setReviewInfo(rs.getString("review_info"));
			review.setRatingNumber(rs.getInt("rating_number"));

			return review;
		}
	}
    
	// Get Review By Product ID
	@Override
	public List<Review> getReviewByProductId(Integer productId) {
		
		String sql = "SELECT * FROM review where product_id =:productId";
		List<Review> reviews = this.namedParameterJdbcTemplate.query(sql, 
				this.getSqlParameterSource(null, null, productId, null, null, null, null), new ReviewMapper());
		
		return reviews;
	}
    
	//productId で レピューを削除する。
	@Override
	public void deleteReviewByProductId(Integer productId) {
		
	    String sql = "DELETE FROM review where product_id =:productId ";
	    this.namedParameterJdbcTemplate.update(sql, this.getSqlParameterSource(null, null, productId, null, null, null, null));	
	}
	
	@Override
	public void deleteReviewByUserId(Integer userId) {
		
		String sql="DELETE from review where user_id =:userId";
		this.namedParameterJdbcTemplate.update(sql, this.getSqlParameterSource(null, userId, null, null, null, null, null));	
	}
	
	@Override
	public void addReview(Integer reviewId, Integer userId, Integer productId) {
		// TODO Auto-generated method stub

	}
	
	
    
	//レビューを追加する。
	@Override
	public Review updateReview(Integer reviewId) {
		// TODO Auto-generated method stub
		return null;
	}
    
	//レピューID で レピューを削除する。
	@Override
	public void deleteReviewByReviewId(Integer reviewId) {
		// TODO Auto-generated method stub

	}



}
