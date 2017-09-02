package com.freebies.auth;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.freebies.exception.SystemException;
import com.freebies.util.LoggerUtil;

/**
 * 
 * @author Bala
 *
 */

@ControllerAdvice
public class FreebiesControllerAdvice {

	private LoggerUtil logger = new LoggerUtil(FreebiesControllerAdvice.class);

	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@ExceptionHandler({ RuntimeException.class })
	public ModelAndView handleException(Exception ex) {
		ModelAndView view = new ModelAndView("error");
		view.addObject("errorDesc", ex.getMessage());
		logger.error(ex.getMessage(), ex);
		return view;
	}

	@ExceptionHandler({ Exception.class, ServletException.class })
	public ModelAndView handleSystemException(Exception ex, HttpServletRequest request) {
		ModelAndView view = new ModelAndView("error");
		if (ex instanceof SystemException) {
			SystemException systemException = (SystemException) ex;
			view.addObject("errorcode", systemException.getErrorInfo().getErrorCode());
			view.addObject("errorDesc", systemException.getErrorInfo().getErrorDesc());
		} else {
			view.addObject("errorDesc", ex.getMessage());
		} 
		logger.error(ex.getMessage(), ex);
		return view;
	}
}
