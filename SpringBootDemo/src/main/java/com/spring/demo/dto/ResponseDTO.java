package com.spring.demo.dto;

public class ResponseDTO {

	private String message;
	
	private int status_code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus_code() {
		return status_code;
	}

	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}
	
	
}
