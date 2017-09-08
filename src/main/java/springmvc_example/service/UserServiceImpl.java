package springmvc_example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springmvc_example.dao.UserDao;
import springmvc_example.model.Users;

@Service
public class UserServiceImpl implements UserService {
   
	UserDao userDao;
	
    @Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<Users> getListUser() {
		
		return userDao.getListUser();
	}


	public Users findUserbyUserId(String userId) {
		return userDao.findUserbyUserId(userId);
		
	}

	
	public void updateUser(String userId, String password) {
		userDao.updateUser(userId, passwordEncoder.encode(password));

	}


	public void addUser(String username, String password) {
		userDao.addUser(username, passwordEncoder.encode(password));

	}


	public boolean userExists(String userId) {
		
		return userDao.userExists(userId);
	}

	@Override
	public void deleteUser(String userId) {
		
		userDao.deleteUser(userId);
		
	}
	

}
