package com.spring.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -630192849892310801L;

	private Long userId;
	
	private String userName;
	
	public UserNotFoundException(Long userId, String userName) {
		
		super(String.format("User Not Found with User Id %d and User Name : '%s'", userId,userName));
		this.userId = userId;
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}
	
	
}
