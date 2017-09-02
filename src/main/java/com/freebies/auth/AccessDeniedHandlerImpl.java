/**
 * 
 */
package com.freebies.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.freebies.constants.ErrorCodes.LoginErrorCode;


/**
 * 
 * This class will handle access denied exception.
 * @author Bala.
 *
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

	/* (non-Javadoc)
	 * @see org.springframework.security.web.access.AccessDeniedHandler#handle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.access.AccessDeniedException)
	 */
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
			response.sendRedirect("/freebies/login?error="+LoginErrorCode.AccessDenied.name());
	}

}
