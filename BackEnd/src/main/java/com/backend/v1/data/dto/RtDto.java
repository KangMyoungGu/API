package com.backend.v1.data.dto;

import java.util.ArrayList;
import java.util.List;

import com.backend.v1.data.dto.product.OuterDto;

public class RtDto<T> {
	String rtCode;
	String rtMsg;
	
	List<OuterDto> list;

	public String getRtCode() {
		return rtCode;
	}

	public void setRtCode(String rtCode) {
		this.rtCode = rtCode;
	}

	public String getRtMsg() {
		return rtMsg;
	}

	public void setRtMsg(String rtMsg) {
		this.rtMsg = rtMsg;
	}

	public List<OuterDto> getList() {
		return list;
	}

	public void setList(List<OuterDto> list) {
		this.list = list;
	}
	
}
