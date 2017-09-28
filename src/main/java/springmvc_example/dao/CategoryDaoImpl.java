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


@Repository
public class CategoryDaoImpl implements CategoryDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {

		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	private SqlParameterSource getSqlParameterSource(String categoryId, Timestamp createAt, Timestamp updateAt) {

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();

		if (categoryId != null) {
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
	//Delete Category By Category ID.
	public void deleteCategory(String categoryId) {

		String sql1 = "DELETE FROM category where category_id =:categoryId";

		namedParameterJdbcTemplate.update(sql1, getSqlParameterSource(categoryId, null, null));

	}

	@Override
	public List<Category> listCategory() {
		
		String sql = "Select category_id from category";
		
		List<Category> list = this.namedParameterJdbcTemplate.query(sql, getSqlParameterSource(null, null, null), new CategoryMapper());
		
		return list;
	}

	@Override
	public void addCategory(String categoryId) {
		
		String sql = "INSERT INTO category(category_id, create_at, update_at) VALUES(:categoryId, now(), now())";
		this.namedParameterJdbcTemplate.update(sql, this.getSqlParameterSource(categoryId, null, null));
	}

}
