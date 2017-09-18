package springmvc_example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import springmvc_example.dao.UserDao;

import springmvc_example.model.Users;

@Repository
public class UserDaoImpl implements UserDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	private SqlParameterSource getSqlParameterSource(String userId, String password) {
		
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		
		if (userId != null) {
			parameterSource.addValue("userId", userId);
		}
		
		if (password != null) {
			parameterSource.addValue("password", password);
		}

		return parameterSource;
	}

	private static final class UserMapper implements RowMapper<Users> {

		public Users mapRow(ResultSet rs, int numRow) throws SQLException {
			
			String userId = rs.getString("user_id");
			String password = rs.getString("password");

			return new Users(userId, password);
		}
	}
	
	// return all of users.
	@Override
	public List<Users> getAllUser() {

		String sql = "SELECT * from users";
		
		List<Users> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(null, null), new UserMapper());

		return list;
	}
    
	// ユーザーIDでユーザーを検索する。
	public Users findUserbyUserId(String userId) {

		String sql = "select user_id, password from users where user_id= :userId";
		Users user = namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterSource(userId, null),
				new UserMapper());

		return user;
	}
    
	//ユーザー情報を変更する。
	public void updateUser(String userId, String password) {
		
		String sql = "update users set password =:password where user_id= :userId";
        namedParameterJdbcTemplate.update(sql, getSqlParameterSource(userId, password));
	}
	
    //ユーザーを追加する
	public void addUser(String userId, String password) {
		
		// USERSのテーブルをUPDATEする
		String sql = "insert into users(user_id,password) values (:userId, :password)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(userId, password));

		// USER_ROLEのテーブルをUPDATEする
		sql = "insert into user_roles(user_id,role) values (:userId,'ROLE_USER')";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(userId, password));
	}
    
	//ユーザーを削除する
	public void deleteUser(String userId) {
		
		String sql = "delete from users where user_id= :userId";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(userId, null));
	}
    
	//ユーザーがあるかどうかチェックする。
	public boolean userExists(String userId) {
		
		String sql = "select * from users where user_id = :userId";
		List<Users> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(userId, null), new UserMapper());
		
		if (list.size() > 0) {
			return true;
		}

		return false;
	}
    
	
	public List<String> getUserRoles(String userId) {
		
		String sql = "select role from user_roles where user_id =:userId";
		List<String> roles = namedParameterJdbcTemplate.queryForList(sql, getSqlParameterSource(userId, null),
				String.class);

		return roles;
	}

}
