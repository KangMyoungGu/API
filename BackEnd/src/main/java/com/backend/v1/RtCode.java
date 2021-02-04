package com.backend.v1;

import org.springframework.http.HttpStatus;

public enum RtCode {
    // 2XX SUCCESS Cases - Commons
	RT_SUCCESS("A200000", HttpStatus.OK, "Request Success"),
	RT_EXECUTED("A200001", HttpStatus.CREATED, "Request Executed"),
	
	RT_TOKEN_NOT_FOUND("A300001", HttpStatus.INTERNAL_SERVER_ERROR, "Token Not Found"),
	RT_TOKEN_NOT_FORGERY("A300002", HttpStatus.INTERNAL_SERVER_ERROR, "Token Forgery"),

	RT_PARAMETER_ERROR("A400001", HttpStatus.INTERNAL_SERVER_ERROR, "Parameter Error"),
	RT_CONFICT_USER_LOGIN_ID("A400002", HttpStatus.CONFLICT, "Aleady Exist"),

	RT_USER_NOT_FOUND("A500001", HttpStatus.OK, "User Not Found"),
	RT_LOGIN_PASSWORD_WRONG("A500002", HttpStatus.OK, "User Not Found"),

	// USER 에게 뭔가 요청이 허용될 권한이 없음
	RT_FORBIDDEN_ACCESS("A600001", HttpStatus.FORBIDDEN, "Forbidden Access"),
	
	// 주문 정책으로 인한 사유
	RT_FORBIDDEN_BY_ORDER_POLICY("A600001", HttpStatus.BAD_REQUEST, "Forbidden By Policy"),
	
	// 서버 에러
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
