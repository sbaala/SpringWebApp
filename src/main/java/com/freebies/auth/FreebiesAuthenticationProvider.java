package com.freebies.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.freebies.model.User;
import com.freebies.service.user.UserService;

/**
 * 
 * @author Bala
 *
 */
@Component
public class FreebiesAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UserService userService;
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {


		String username = String.valueOf(authentication.getPrincipal());
		String password = String.valueOf(authentication.getCredentials());
		
		User user = userService.findByUserId(username);
		
		if(password.equals(user.getPassword()))		
		   return authentication;
		else
		   throw new BadCredentialsException("Invalid Username and Password");
		
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
