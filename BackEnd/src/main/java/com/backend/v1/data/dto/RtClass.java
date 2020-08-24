package com.backend.v1.data.dto;

import lombok.Data;

@Data
public class RtClass<T> {
	String rtCode;
	String rtMsg;
	
	Object data;
}
