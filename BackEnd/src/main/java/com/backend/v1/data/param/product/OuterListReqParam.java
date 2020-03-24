package com.backend.v1.data.param.product;

public class OuterListReqParam {
	private String comCode;		// 공통코드(상품대분류코드)
	private String comSubCode;
	
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getComSubCode() {
		return comSubCode;
	}
	public void setComSubCode(String comSubCode) {
		this.comSubCode = comSubCode;
	}

	
}
