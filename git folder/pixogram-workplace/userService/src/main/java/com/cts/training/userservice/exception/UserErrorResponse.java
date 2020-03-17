package com.cts.training.userservice.exception;

public class UserErrorResponse {

	private String message;
	private Integer errorCode;
	private Long timeStamp;
	
	public UserErrorResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public UserErrorResponse(String message, Integer errorCode, Long timeStamp) {
		
		this.message = message;
		this.errorCode = errorCode;
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
