package com.pfms.UserService.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserManagmentException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public static final Logger logger = LoggerFactory.getLogger(UserManagmentException.class);
	
	 public UserManagmentException(String errorMessage, Throwable err) {
		 super(errorMessage, err);
		 logger.error(errorMessage,err);
		 
	    }

	public UserManagmentException(String errorMessage) {
		 logger.error(errorMessage);
	}

}
