package com.backend.v1.data.dto.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="TBL_PROD_MASTER")
@Data
public class ProdDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="COM_CD")
	private String commonCode;
	
	@Column(name="COM_SUB_CD")
	private String commonSubCode;
	
	@Column(name="COST_PRICE")
	private String costPrice;
	
	@Column(name="MOD_DATE")
	private String modDate;
	
	@Column(name="MOD_USER_ID")
	private String modUserId;
	
	@Id
	@Column(name="PROD_CD")
	private String prodCode;
	
	@Column(name="PROD_MASTER_IMG_NM")
	private String prodMasterImageName;
	
	@Column(name="PROD_MASTER_IMG_PATH")
	private String prodMasterImagePath;
	
	@Column(name="PROD_NM")
	private String prodName;
	
	@Column(name="REG_DATE")
	private String regDate;
	
	@Column(name="REG_USER_ID")
	private String regUserId;
	
	@Column(name="SELL_PRICE")
	private String sellPrice;
	
	@Column(name="USE_YN")
	private String useYn;
}
