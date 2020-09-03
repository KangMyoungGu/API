package com.backend.v1.data.dto.product;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProdColorDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private String prodColorCd;
	private String prodColorNm;
}
