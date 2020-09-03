package com.backend.v1.data.dto.product;

import lombok.Data;

@Data
public class ProdSizeDto {
	private String prodCd;
	private String prodSize;
	private String prodColorCd;
	private String remainingAmount;
}