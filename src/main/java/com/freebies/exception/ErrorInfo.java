package com.freebies.exception;

import com.freebies.util.LoggerUtil;

/**
 * 
 * @author Bala
 *
 */
public class ErrorInfo {
	private LoggerUtil logger = new LoggerUtil(ErrorInfo.class);
	/**
	 * error code.
	 */
	private String errorCode;
	/**
	 * error description.
	 */
	private String errorDesc;
	
	/**
	 * default constructor.
	 */
	public ErrorInfo(){
		
	}
	
	
	
	public ErrorInfo(String message,Exception e){
		logger.error(message, e);
		
	}
	
	
	/**
	 * Construction with error code and description.
	 * @param code error code
	 * @param desc error description.
	 */
	public ErrorInfo(String code,String desc){
		errorCode =code;
		errorDesc = desc;
	}
	
	
	public ErrorInfo(String code){
		errorCode =code;		
	}
	
	/**
	 * this method returns the error code.
	 * @return error code
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * this methods set the error code.
	 * @param errorCode error code to be set.
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * this method returns the error description.
	 * @return error description.
	 */
	public String getErrorDesc() {
		return errorDesc;
	}
	/**
	 * this methods set the error description.
	 * @param errorDesc error description to be set.
	 */
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	
	
}
