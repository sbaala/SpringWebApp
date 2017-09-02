package com.freebies.Freebies;

import java.util.Locale;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.freebies.auth.SecurityFilter;

/**
 * 
 * @author Bala
 *
 */
@Configuration
@ComponentScan("com.freebies.*")
public class SpringWebInitializer extends WebMvcConfigurerAdapter {
	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/").addResourceLocations("/freebies/login");
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/").setCachePeriod(3600);
		
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		//registry.addViewController("/").setViewName("/flooresense/login");
		registry.addViewController("/freebies").setViewName("tenantAdmin");
		registry.addViewController("/login").setViewName("login");
	}

	

	@Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
            	 connector.setAttribute("server", "FreebiesServer");
            }
        });

        return tomcat;
    }
	
	
	
	  @Bean
	    public ReloadableResourceBundleMessageSource messageSource(){
	       ReloadableResourceBundleMessageSource rrbm = new ReloadableResourceBundleMessageSource();
	       rrbm.setBasenames("classpath:label");
	       rrbm.setUseCodeAsDefaultMessage(true);
	       rrbm.setDefaultEncoding("UTF-8");
	       return rrbm;
	    }
	    
	    @Bean
	    public SessionLocaleResolver localeResolver(){
	       SessionLocaleResolver localeResolver = new SessionLocaleResolver();
	       localeResolver.setDefaultLocale(new Locale("en"));
	       return localeResolver;
	    }
	    
	    @Bean
	    public LocaleChangeInterceptor localeChangeInterceptor(){
	       LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
	       changeInterceptor.setParamName("lang");
	       return changeInterceptor;
	    }
	    
	    @Bean
		public FilterRegistrationBean filterRegistrationBean() {
			SecurityFilter securityFilter = new SecurityFilter();

			FilterRegistrationBean registrationBean = new FilterRegistrationBean();
			registrationBean.setFilter(securityFilter);
			registrationBean.addUrlPatterns("/*");
			return registrationBean;
		}
		

}
