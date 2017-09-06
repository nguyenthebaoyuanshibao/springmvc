package springmvc_example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springmvc_example.dao.UserDao;
import springmvc_example.model.UserInfo;

@Service
public class UserServiceImpl implements UserService {
   
	UserDao userDao;
	
    @Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<UserInfo> list() {
		
		return userDao.list();
	}


	public UserInfo findUserbyUsername(String username) {
		return userDao.findUserbyUsername(username);
		
	}

	
	public void update(String username, String password) {
		userDao.update(username, passwordEncoder.encode(password));

	}


	public void add(String username, String password) {
		userDao.add(username, passwordEncoder.encode(password));

	}


	public boolean userExists(String username) {
		
		return userDao.userExists(username);
	}

	@Override
	public void delete(String username) {
		
		userDao.delete(username);
		
	}

}
