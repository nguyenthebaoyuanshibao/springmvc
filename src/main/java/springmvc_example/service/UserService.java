package springmvc_example.service;

import java.util.List;

import springmvc_example.model.Users;
public interface UserService {

	public List<Users> getAllUser();

	public Users findUserbyUserId(String userId);

	public void updateUser(String userId, String password);

	public void addUser(String userId, String password);

	public void deleteUser(String userId);

	public boolean userExists(String userId);
    
	
}
