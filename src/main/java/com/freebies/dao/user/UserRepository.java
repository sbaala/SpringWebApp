package com.freebies.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.freebies.model.User;

/**
 * 
 * @author Bala
 *
 */
@Component
public interface UserRepository extends JpaRepository<User, String>{

	public User findByUserId(String userId);
}
