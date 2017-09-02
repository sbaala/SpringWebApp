package com.freebies.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

/**
 * 
 * @author Bala
 *
 */
public class LoggerUtil {

	private Logger logger = null;

	public LoggerUtil() {
	}
	
	public LoggerUtil(Class<?> clazz) {
		this.logger = LoggerFactory.getLogger(clazz);
	}

	public boolean isTraceEnabled() {
		return logger.isTraceEnabled();
	}

	public void trace(String msg) {
		logger.trace(msg);
	}

	public void trace(String format, Object arg) {
		logger.trace(format, arg);
	}

	public void trace(String format, Object arg1, Object arg2) {
		logger.trace(format, arg1, arg2);
	}

	public void trace(String format, Object[] argArray) {
		logger.trace(format, argArray);
	}

	public void trace(String msg, Throwable t) {
		logger.trace(msg, t);
	}

	public boolean isTraceEnabled(Marker marker) {
		return logger.isDebugEnabled(marker);
	}

	public void trace(Marker marker, String msg) {
		logger.trace(marker, msg);
	}

	public void trace(Marker marker, String format, Object arg) {
		logger.trace(marker, format, arg);
	}

	public void trace(Marker marker, String format, Object arg1, Object arg2) {
		logger.trace(marker, format, arg1, arg2);
	}

	public void trace(Marker marker, String format, Object[] argArray) {
		logger.trace(marker, format, argArray);
	}

	public void trace(Marker marker, String msg, Throwable t) {
		logger.trace(marker, msg, t);
	}

	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	public void debug(String msg) {
		logger.debug(msg);
	}

	public void debug(String format, Object arg) {
		logger.debug(format, arg);
	}

	public void debug(String format, Object arg1, Object arg2) {
		logger.debug(format, arg1, arg2);
	}

	public void debug(String format, Object[] argArray) {
		logger.debug(format, argArray);
	}

	public void debug(String msg, Throwable t) {
		logger.debug(msg, t);
	}

	public boolean isDebugEnabled(Marker marker) {
		return logger.isDebugEnabled(marker);
	}

	public void debug(Marker marker, String msg) {
		logger.debug(marker, msg);
	}

	public void debug(Marker marker, String format, Object arg) {
		logger.debug(marker, format, arg);
	}

	public void debug(Marker marker, String format, Object arg1, Object arg2) {
		logger.debug(marker, format, arg1, arg2);
	}

	public void debug(Marker marker, String format, Object[] argArray) {
		logger.debug(marker, format, argArray);
	}

	public void debug(Marker marker, String msg, Throwable t) {
		logger.debug(marker, msg, t);
	}

	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	public void info(String msg) {
		logger.info(msg);
	}

	public void info(String format, Object arg) {
		logger.info(format, arg);
	}

	public void info(String format, Object arg1, Object arg2) {
		logger.info(format, arg1, arg2);
	}

	public void info(String format, Object[] argArray) {
		logger.info(format, argArray);
	}

	public void info(String msg, Throwable t) {
		logger.info(msg, t);
	}

	public boolean isInfoEnabled(Marker marker) {
		return logger.isInfoEnabled(marker);
	}

	public void info(Marker marker, String msg) {
		logger.info(marker, msg);
	}

	public void info(Marker marker, String format, Object arg) {
		logger.info(marker, format, arg);
	}

	public void info(Marker marker, String format, Object arg1, Object arg2) {
		logger.info(marker, format, arg1, arg2);
	}

	public void info(Marker marker, String format, Object[] argArray) {
		logger.info(marker, format, argArray);
	}

	public void info(Marker marker, String msg, Throwable t) {
		logger.info(marker, msg, t);

	}

	public boolean isWarnEnabled() {
		return logger.isWarnEnabled();
	}

	public void warn(String msg) {
		logger.warn(msg);
	}

	public void warn(String format, Object arg) {
		logger.warn(format, arg);
	}

	public void warn(String format, Object[] argArray) {
		logger.warn(format, argArray);
	}

	public void warn(String format, Object arg1, Object arg2) {
		logger.warn(format, arg1, arg2);
	}

	public void warn(String msg, Throwable t) {
		logger.warn(msg, t);
	}

	public boolean isWarnEnabled(Marker marker) {
		return logger.isWarnEnabled(marker);
	}

	public void warn(Marker marker, String msg) {
		logger.warn(marker, msg);
	}

	public void warn(Marker marker, String format, Object arg) {
		logger.warn(marker, format, arg);
	}

	public void warn(Marker marker, String format, Object arg1, Object arg2) {
		logger.warn(marker, format, arg1, arg2);
	}

	public void warn(Marker marker, String format, Object[] argArray) {
		logger.warn(marker, format, argArray);
	}

	public void warn(Marker marker, String msg, Throwable t) {
		logger.warn(marker, msg, t);
	}

	public boolean isErrorEnabled() {
		return logger.isDebugEnabled();
	}

	public boolean isErrorEnabled(Marker marker) {
		return logger.isErrorEnabled(marker);
	}

	public void error(String msg) {
		logger.error(msg);
		
	}
	
	public void error(String format, Object arg) {
		logger.error(format, arg);
		
	}

	public void error(String format, Object[] argArray) {
		logger.error(format, argArray);
		
	}

	public void error(String msg, Throwable t) {
		logger.error(msg, t);
		
	}
	
	public void errorForEmailSender(String msg, Throwable t) {
		logger.error(msg, t);
	}
	
	public void error(Marker marker, String msg) {
		logger.error(marker, msg);
		
	}

	public void error(Marker marker, String msg, Throwable t) {
		logger.error(marker, msg, t);
		
	}
	
	public void errorWithoutEmail(String msg, Throwable t) {
		logger.error(msg, t);
	}
	
	


}
