package com.freebies.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import com.freebies.model.User;
import com.freebies.service.user.UserService;
import com.freebies.util.ApplicationAuthToken;
import com.freebies.util.LoggerUtil;

/**
 * 
 * @author Bala
 *
 */
@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

	
	@Autowired
	ReloadableResourceBundleMessageSource messageSource;
	
	@Autowired
	UserService userService;
		
	@Autowired
	LocaleResolver localeResolver;

	private static final LoggerUtil logger = new LoggerUtil(AuthSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth)
			throws IOException, ServletException {

		String redirectUrl = "index";

		
		User user = userService.findByUserId(String.valueOf(auth.getPrincipal()));

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("Admin"));
		

		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(auth.getPrincipal(),
				auth.getCredentials(), authorities);

		ApplicationAuthToken token = new ApplicationAuthToken(authToken);

		token.setLoggedInUserName(user.getUserId());
		
		token.setLoggedInRoleNames("Admin");		
		token.setLocale("en");	
		token.setFirstName(user.getFirstName());

		messageSource.clearCache();
	
			messageSource.setBasename("classpath:label");
		
		
			localeResolver.setLocale(req, resp, new Locale("en"));
      

		SecurityContextHolder.getContext().setAuthentication(token);

		resp.sendRedirect(redirectUrl);
	}

}
