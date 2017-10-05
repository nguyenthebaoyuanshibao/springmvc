package springmvc_example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springmvc_example.dao.ReviewDao;
import springmvc_example.dao.SaleDao;
import springmvc_example.dao.UserDao;
import springmvc_example.dao.UserRoleDao;
import springmvc_example.model.UserRole;
import springmvc_example.model.Users;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ReviewDao reviewDao;
	
	@Autowired
	UserRoleDao userRoleDao;
	
	@Autowired
	SaleDao saleDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<Users> getAllUser() {

		return userDao.getAllUser();
	}

	public Users findUserbyUserId(Integer userId) {
		
		return userDao.findUserbyUserId(userId);
	}

	// Update User Information.
	public void updateUser(Integer userId, String userName, String password) {

		userDao.updateUser(userId,userName, passwordEncoder.encode(password));
	}

	// Add User.
	public void addUser(String userName, String password) {
		
        if(!userDao.userExists(userName)) {
        	
			userDao.addUser(userName, passwordEncoder.encode(password));
        }
    }

	// check if user exist.
	public boolean userExists(String userName) {

		return userDao.userExists(userName);
	}

	// Delete User
	@Override
	public void deleteUser(Integer userId) {
		
		userRoleDao.deleteUser(userId);
		reviewDao.deleteReviewByUserId(userId);
		saleDao.deleteSaleByUserId(userId);
		userDao.deleteUser(userId);
	}

	@Override
	public Users findUserbyUserName(String userName) {
		
		return userDao.findUserbyUserName(userName);
	}

	@Override
	public List<String> getUserRoles(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRole addUserRole(Integer userId) {
		return this.userRoleDao.addUserRole(userId);
	}

}
