package springmvc_example.dao;

import springmvc_example.model.UserRole;

public interface UserRoleDao {
	
	void deleteUser(Integer userId);
	
	UserRole addUserRole(Integer userId);

}
