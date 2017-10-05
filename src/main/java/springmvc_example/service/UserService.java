package springmvc_example.service;

import java.util.List;

import springmvc_example.model.UserRole;
import springmvc_example.model.Users;
public interface UserService {

    public List<Users> getAllUser();
	
	public Users findUserbyUserId(Integer userId);
	
	public Users findUserbyUserName(String userName);
	
	public void updateUser(Integer userId, String userName, String password);
	
	public void addUser(String userName, String password);
	
	UserRole addUserRole(Integer userId);
	
	public void deleteUser(Integer userId);
	
	public boolean userExists(String userName);
	
	public List<String> getUserRoles(Integer userId);
    
	
}
