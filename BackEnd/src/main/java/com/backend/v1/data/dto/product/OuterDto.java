package com.backend.v1.data.dto.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OuterDto {
	String COM_CD;
	String COM_SUB_CD;
	int COST_PRICE;
	String MOD_DATE;
	String MOD_USER_ID;
	String PROD_CD;
	String PROD_MASTER_IMG_NM;
	String PROD_MASTER_IMG_PATH;
	String PROD_NM;
	String REG_DATE;
	String REG_USER_ID;
	int SELL_PRICE;
	String USE_YN;
}