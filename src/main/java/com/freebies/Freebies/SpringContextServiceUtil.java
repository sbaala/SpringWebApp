package com.freebies.Freebies;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 * This class loads all the beans defined in the applicationContext.xml and maintains the 
 * Spring application context.
 * 
 * @author Bala
 *
 */

@Component
public class SpringContextServiceUtil  implements ApplicationContextAware{
	
	private static ApplicationContext applicationContext;
	
	/**
	 * This method returns the bean from the application context.
	 * @param appObject
	 * @return identified object
	 */
	public static Object getApplicationObject(String applicationObject){
		if(applicationContext == null){
			return null;
		}
		
		return applicationContext.getBean(applicationObject) ;
	}
	
	
	public static <T> T getApplicationObjectByClassName(Class<T> clazz){		
		return applicationContext.getBean(clazz);
	}
	
	
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		applicationContext = context;
		
	}

		
}
