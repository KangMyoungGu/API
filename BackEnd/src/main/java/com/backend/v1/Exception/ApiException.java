package com.backend.v1.Exception;


import com.backend.v1.RtCode;

public class ApiException extends RuntimeException {
	private static final long serialVersionUID = 7999421329089609170L;

	private RtCode rtCode;

	public ApiException() {
		super();
	}

	public ApiException(Exception e) {
		super(e);
	}

	public ApiException(RtCode rtCode) {
		super(rtCode.getErrorMessage());
		this.rtCode = rtCode;
	}

	public ApiException(RtCode rtCode, Throwable throwable) {
		super(rtCode.getErrorMessage(), throwable);
		this.rtCode = rtCode;
	}

	public RtCode getRtCode() {
		return rtCode;
	}
}
