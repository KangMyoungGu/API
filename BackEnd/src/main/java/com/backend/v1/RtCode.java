package com.backend.v1;

import org.springframework.http.HttpStatus;

public enum RtCode {
    // 2XX SUCCESS Cases - Commons
	RT_SUCCESS("A200000", HttpStatus.OK, "Request Success"),
	RT_EXECUTED("A200001", HttpStatus.CREATED, "Request Executed"),
	
	RT_TOKEN_NOT_FOUND("A300001", HttpStatus.INTERNAL_SERVER_ERROR, "Token Not Found"),
	RT_TOKEN_NOT_FORGERY("A300002", HttpStatus.INTERNAL_SERVER_ERROR, "Token Forgery"),

	RT_PARAMETER_ERROR("A400001", HttpStatus.INTERNAL_SERVER_ERROR, "Parameter Error"),

	RT_USER_NOT_FOUND("A500001", HttpStatus.OK, "User Not Found"),
	RT_LOGIN_PASSWORD_WRONG("A500002", HttpStatus.OK, "User Not Found"),

	
	RT_INTERNAL_ERROR("A999999", HttpStatus.INTERNAL_SERVER_ERROR, "Server Error");
	
	
	private final HttpStatus httpStatus;
	private final String errorMessage;
	private final String errorCode;

	private RtCode(String errorCode, HttpStatus httpStatus, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
