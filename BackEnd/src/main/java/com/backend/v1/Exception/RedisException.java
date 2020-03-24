package com.backend.v1.Exception;

import com.backend.v1.RtCode;

public class RedisException extends ApiException {

	private static final long serialVersionUID = -5964056605103687039L;

	public RedisException() {
		super();
	}

	public RedisException(RtCode rtCode) {
		super(rtCode);
	}

	public RedisException(RtCode rtCode, Throwable throwable) {
		super(rtCode, throwable);
	}
}
