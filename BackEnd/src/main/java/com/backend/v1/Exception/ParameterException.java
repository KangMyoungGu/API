package com.backend.v1.Exception;


import com.backend.v1.RtCode;

public class ParameterException extends ApiException {
	private static final long serialVersionUID = 6362377491745911826L;

	public ParameterException() {
		super();
	}

	public ParameterException(RtCode rtCode) {
		super(rtCode);
	}
}
