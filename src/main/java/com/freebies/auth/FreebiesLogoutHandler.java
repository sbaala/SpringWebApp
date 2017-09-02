package com.freebies.auth;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Bala
 *
 */
@Component
public class FreebiesLogoutHandler implements LogoutSuccessHandler {
	
	
	
	private String successURL = "login";
	
	public void setSuccessURL(String successURL) {
		this.successURL = successURL;
	}

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
		if (auth == null) {
			response.sendRedirect(successURL);
			return;
		}
		
		if(request != null) {
		
		}
	
		response.sendRedirect(successURL);
	}

	
}
