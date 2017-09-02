package com.freebies.auth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author Bala
 *
 */
public class SecurityFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) sRequest;
		
		if (request.getContentType() != null
				&& !request.getMethod().equals("GET")
				&& request.getContentType().toLowerCase().indexOf("multipart/form-data") == -1) {
			
			sRequest = new XSSRequestWrapper((HttpServletRequest) request);
		} 
		
		chain.doFilter(sRequest, sResponse);
	}

}