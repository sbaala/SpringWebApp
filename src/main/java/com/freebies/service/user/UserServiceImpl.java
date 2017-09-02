package com.freebies.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freebies.dao.user.UserRepository;
import com.freebies.model.User;

/**
 * 
 * @author Bala
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User findByUserId(String userId) {
		
		
		User user = userRepository.findByUserId(userId);
		
		return user;
	}

}
