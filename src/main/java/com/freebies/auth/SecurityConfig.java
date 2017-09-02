package com.freebies.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.freebies.constants.ErrorCodes.LoginErrorCode;
/**
 * 
 * @author Bala
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private FreebiesAuthenticationProvider authProvider;

	@Autowired
	private AuthSuccessHandler authenticationSuccessHandler;

	@Autowired
	private AuthFailureHandler authenticationFailureHandler;
	
	@Autowired
	private FreebiesLogoutHandler logoutSuccessHandler;
	
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
		web.ignoring().antMatchers("/static/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
				.antMatchers("/login").access("isAuthenticated() or isAnonymous()")
				.antMatchers("/index").access("isAnonymous() or isAuthenticated()")
				.antMatchers("/**").access("isAuthenticated()")
				//.antMatchers("/index").access("isAnonymous() or isAuthenticated()")
				.anyRequest().denyAll()
		
		.and().formLogin()
				.successHandler(authenticationSuccessHandler)
				.failureHandler(authenticationFailureHandler)
				.loginPage("/login").loginProcessingUrl("/authenticate")
				.usernameParameter("j_username").passwordParameter("j_password")
				
		.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login")
				.logoutSuccessHandler(logoutSuccessHandler)
				.invalidateHttpSession(true)
				.deleteCookies("FSSESSIONID")
	   
		.and().exceptionHandling().accessDeniedHandler(accessDeniedHandler)
				
		.and().sessionManagement()
				.sessionFixation().changeSessionId()
				.invalidSessionUrl("/login?error="+LoginErrorCode.SessionExpired.name())
				.sessionAuthenticationErrorUrl("/login?error="+LoginErrorCode.SessionExpired.name())
				.maximumSessions(1)
					.expiredUrl("/login?error="+LoginErrorCode.AnotherLoginDetected.name())
					.sessionRegistry(sessionRegistry());
	}
	
	@Bean
    public static ServletListenerRegistrationBean<?> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
    }

	@Bean
	public SessionRegistry sessionRegistry() {
		SessionRegistry sessionRegistry = new SessionRegistryImpl();
		return sessionRegistry;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider).eraseCredentials(true);

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider).eraseCredentials(true);
	}

}
