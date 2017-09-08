package springmvc_example.dao;

import java.util.List;

import springmvc_example.model.Users;


public interface UserDao {
	
	public List<Users> getListUser();
	
	public Users findUserbyUserId(String userId);
	
	public void updateUser(String userId, String password);
	
	public void addUser(String userId, String password);
	
	public void deleteUser(String userId);
	
	public boolean userExists(String userId);
	
	public List<String> getUserRoles(String userId);
}
