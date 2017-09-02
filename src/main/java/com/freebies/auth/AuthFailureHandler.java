package com.freebies.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.freebies.model.User;
import com.freebies.service.user.UserService;

/**
 * 
 * @author Bala
 *
 */

@Component
public class AuthFailureHandler implements AuthenticationFailureHandler {
	
	@Autowired
	UserService userService;


	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException auth) throws IOException, ServletException {
		
		String errorMsg = auth.getMessage();
		
		if (auth.getMessage().equalsIgnoreCase("NoMatchedUser")) {
			errorMsg = "Invalid User";
		}

		if (auth.getMessage().equalsIgnoreCase("NotAuthorized")) {
			errorMsg = "Unauthorized User";
		}

		
		if (auth.getMessage().equalsIgnoreCase("AccountLocked")) {
			errorMsg = "Account Locked Please Contact Administrator";
		}
		if (auth.getMessage().equalsIgnoreCase("CredentialNotMatched")) {
			
			User user = userService.findByUserId( req.getParameter("j_username"));
			
			errorMsg="CredentialNotMatched";

		}

		resp.sendRedirect("login?error=" + errorMsg);
	}

}