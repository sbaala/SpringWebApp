package com.freebies.auth;

import javax.management.relation.RoleInfo;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.freebies.util.ApplicationAuthToken;

/**
 * 
 * @author Bala
 *
 */
@Component
public class AuthorizationUtil {

	public static String getLoggedInUser() {
		return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	public static String getLoggedInUserName() {
		ApplicationAuthToken appAuth = (ApplicationAuthToken) SecurityContextHolder.getContext().getAuthentication();
		return appAuth.getLoggedInUserName();
	}

	public static String getLoggedInUserRoleId() {
		ApplicationAuthToken appAuth = (ApplicationAuthToken) SecurityContextHolder.getContext().getAuthentication();
		return appAuth.getLoggedInRoleNames();
	}

	public static Integer getCustomerIdForLoggedInUser() {
		ApplicationAuthToken appAuth = (ApplicationAuthToken) SecurityContextHolder.getContext().getAuthentication();
		return appAuth.getCustomerId();
	}

	public static RoleInfo getLoggedInUserRoleInfo() {
		
		return null;
	}

}
