package com.backend.v1.data.dto.product;

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

	public String getCOM_CD() {
		return this.COM_CD;
	}
	public void setCOM_CD(String COM_CD) {
		this.COM_CD = COM_CD;
	}
	public String getCOM_SUB_CD() {
		return COM_SUB_CD;
	}
	public void setCOM_SUB_CD(String COM_SUB_CD) {
		this.COM_SUB_CD = COM_SUB_CD;
	}
	public int getCOST_PRICE() {
		return this.COST_PRICE;
	}
	public void setCOST_PRICE(int COST_PRICE) {
		this.COST_PRICE = COST_PRICE;
	}
	public String getMOD_DATE() {
		return this.MOD_DATE;
	}
	public void setMOD_DATE(String MOD_DATE) {
		this.MOD_DATE = MOD_DATE;
	}
	public String getMOD_USER_ID() {
		return this.MOD_USER_ID;
	}
	public void setMOD_USER_ID(String MOD_USER_ID) {
		this.MOD_USER_ID = MOD_USER_ID;
	}
	public String getPROD_CD() {
		return this.PROD_CD;
	}
	public void setPROD_CD(String PROD_CD) {
		this.PROD_CD = PROD_CD;
	}
	public String getPROD_MASTER_IMG_NM() {
		return this.PROD_MASTER_IMG_NM;
	}
	public void setPROD_MASTER_IMG_NM(String PROD_MASTER_IMG_NM) {
		this.PROD_MASTER_IMG_NM = PROD_MASTER_IMG_NM;
	}
	public String getPROD_MASTER_IMG_PATH() {
		return PROD_MASTER_IMG_PATH;
	}
	public void setPROD_MASTER_IMG_PATH(String PROD_MASTER_IMG_PATH) {
		this.PROD_MASTER_IMG_PATH = PROD_MASTER_IMG_PATH;
	}
	public String getPROD_NM() {
		return this.PROD_NM;
	}
	public void setPROD_NM(String PROD_NM) {
		this.PROD_NM = PROD_NM;
	}
	public String getREG_DATE() {
		return this.REG_DATE;
	}
	public void setREG_DATE(String REG_DATE) {
		this.REG_DATE = REG_DATE;
	}
	public String getREG_USER_ID() {
		return this.REG_USER_ID;
	}
	public void setREG_USER_ID(String REG_USER_ID) {
		this.REG_USER_ID = REG_USER_ID;
	}
	public int getSELL_PRICE() {
		return this.SELL_PRICE;
	}
	public void setSELL_PRICE(int SELL_PRICE) {
		this.SELL_PRICE = SELL_PRICE;
	}
	public String getUSE_YN() {
		return this.USE_YN;
	}
	public void setUSE_YN(String USE_YN) {
		this.USE_YN = USE_YN;
	}

	
}