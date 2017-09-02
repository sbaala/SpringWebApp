package com.freebies.constants;

/**
 * 
 * @author Bala
 *
 */
public class ErrorCodes {
	
	public enum LoginErrorCode{
		LockedUser,
		InvalidUser,
		InvalidPassword,
		AnotherLoginDetected,
		SessionExpired,
		LoginFailed,
		LoggedOut,
		AccessDenied;
	}

}
