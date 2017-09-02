package com.freebies.util;

import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * 
 * @author Bala
 *
 */
public class ApplicationAuthToken extends UsernamePasswordAuthenticationToken{


	private static final long serialVersionUID = 1L;

	protected Map<String, String> tokens;

	protected String loggedInUserName;

	protected String loggedInRoleNames;

	protected Integer customerId;

	private String locale;	
	
	private String firstName;
	
	private List<String> functionIds;
	
	private String customerType;


	public ApplicationAuthToken(UsernamePasswordAuthenticationToken token) {
		super(token.getPrincipal(), token.getCredentials(), token.getAuthorities());
	}


	public Map<String, String> getTokens() {
		return tokens;
	}

	public void setTokens(Map<String, String> tokens) {
		this.tokens = tokens;
	}

	public String getLoggedInUserName() {
		return loggedInUserName;
	}
	
	public List<String> getFunctionIds() {
		return functionIds;
	}


	public void setFunctionIds(List<String> functionIds) {
		this.functionIds = functionIds;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLoggedInUserName(String userName) {
		this.loggedInUserName = userName;
	}

	public String getLoggedInRoleNames() {
		return loggedInRoleNames;
	}

	public void setLoggedInRoleNames(String loggedInRoleNames) {
		this.loggedInRoleNames = loggedInRoleNames;
	}

	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public String getCustomerType() {
		return customerType;
	}


	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}


	public String getLocale() {
		return locale;
	}


	public void setLocale(String locale) {
		this.locale = locale;
	}


	
}
