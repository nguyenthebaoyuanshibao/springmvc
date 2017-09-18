package springmvc_example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import springmvc_example.model.Category;
import springmvc_example.model.Product;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	
	private SqlParameterSource getSqlParameterSource(String categoryId) {
		
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		
		if(categoryId!=null){
			parameterSource.addValue("categoryId", categoryId);
		}

		return parameterSource;
	}

private static final class CategoryMapper implements RowMapper<Category> {

		public Category mapRow(ResultSet rs, int numRow) throws SQLException {
			
			Category category = new Category();
			
			category.setCategoryId(rs.getString("category_id"));

			return category;
		}
	}

	@Override
	public void deleteCategory(String categoryId) {
		
		//update in category table.
				String sql1 ="DELETE FROM category where category_id =:categoryId";
				namedParameterJdbcTemplate.update(sql1, getSqlParameterSource(categoryId));
			
		
		//update in products table.
		String sql = "DELETE FROM products where category_id =:categoryId";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(categoryId));
		
		
	}

}
