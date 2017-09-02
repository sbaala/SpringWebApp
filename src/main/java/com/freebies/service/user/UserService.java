package com.freebies.service.user;

import org.springframework.stereotype.Service;

import com.freebies.model.User;

/**
 * 
 * @author Bala
 *
 */
@Service
public interface UserService {
	
	public User findByUserId(String userId);

}
