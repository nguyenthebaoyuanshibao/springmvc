package springmvc_example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import springmvc_example.model.UserRole;
import springmvc_example.model.Users;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	private SqlParameterSource getSqlParameterSource(Integer userRoleId, Integer userId, String role) {
		
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		
		if (userRoleId != null) {
			parameterSource.addValue("userRoleId", userRoleId);
		}
		
		if (userId != null) {
			parameterSource.addValue("userId", userId);
		}
		
	    if(role!=null) {
	    	parameterSource.addValue("role", role);
	    }
		
		return parameterSource;
	}

	private static final class UserRoleMapper implements RowMapper<UserRole> {

		public UserRole mapRow(ResultSet rs, int numRow) throws SQLException {
			
			UserRole userRole = new UserRole();
			userRole.setUserRoleId(rs.getInt("user_role_id"));
			userRole.setUserId(rs.getInt("user_id"));
			
			return userRole;
			
		}
	}

	@Override
	public void deleteUser(Integer userId) {
		
		String sql = "delete from user_roles where user_id =:userId";
		this.namedParameterJdbcTemplate.update(sql, this.getSqlParameterSource(null, userId, null));
		

	}

	@Override
	public UserRole addUserRole(Integer userId) {
		String role ="ROLE_USER";
		String sql = "insert into user_roles(user_id, role) values(:userId, :role)";
		this.namedParameterJdbcTemplate.update(sql, this.getSqlParameterSource(null, userId, role ));
		return null;
	}

}
