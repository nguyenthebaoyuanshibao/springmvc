package springmvc_example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import springmvc_example.dao.UserDao;
import springmvc_example.model.Users;

@Service

public class LoginServiceImpl implements UserDetailsService{

	UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException{
		Users userInfo = userDao.findUserbyUserId(userId);
		
		if(userInfo == null) {
			throw new UsernameNotFoundException("userId was not found in the database!");
		}
		
		List<String> roles = userDao.getUserRoles(userId);
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		
		if(roles!= null) {
			for(String role :roles) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}
		
		UserDetails userDetails = new User(userInfo.getUserId(), userInfo.getPassword(), grantList);
        
		return userDetails;
	}

}