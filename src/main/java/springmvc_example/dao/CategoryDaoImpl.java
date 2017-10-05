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

import springmvc_example.model.Category;
import springmvc_example.model.Product;


@Repository
public class CategoryDaoImpl implements CategoryDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {

		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	private SqlParameterSource getSqlParameterSource(Integer categoryId, String categoryName, Timestamp createAt, Timestamp updateAt) {

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();

		if (categoryId != null) {
			parameterSource.addValue("categoryId", categoryId);
		}

		if(categoryName!=null) {
			parameterSource.addValue("categoryName", categoryName);
		}
		return parameterSource;
	}

	private static final class CategoryMapper implements RowMapper<Category> {

		public Category mapRow(ResultSet rs, int numRow) throws SQLException {

			Category category = new Category();

			category.setCategoryId(rs.getInt("category_id"));
			category.setCategoryName(rs.getString("category_name"));
			
			return category;
		}
	}

	@Override
	//Delete Category By Category ID.
	public void deleteCategoryByCategoryId(Integer categoryId) {

		String sql1 = "DELETE FROM category where category_id =:categoryId";

		namedParameterJdbcTemplate.update(sql1, getSqlParameterSource(categoryId, null, null, null));

	}

	@Override
	public List<Category> listCategory() {
		
		String sql = "Select category_id, category_name from category";
		
		List<Category> list = this.namedParameterJdbcTemplate.query(sql, getSqlParameterSource(null, null, null, null), new CategoryMapper());
		
		return list;
	}

	@Override
	public void addCategory(String categoryName) {
		
		String sql = "INSERT INTO category(category_name, create_at, update_at) VALUES(:categoryName, now(), now())";
		this.namedParameterJdbcTemplate.update(sql, this.getSqlParameterSource(null, categoryName, null, null));
	}

	@Override
	public boolean existsCategory(String categoryName) {
		String sql = "Select * from category where category_name =:categoryName";
		
		List<Category> list = this.namedParameterJdbcTemplate.query(sql,  this.getSqlParameterSource(null, categoryName, null, null)
				, new CategoryMapper());
		
		if(list.size()>0) {
			return true;
		}
		
		return false;
	}

}
