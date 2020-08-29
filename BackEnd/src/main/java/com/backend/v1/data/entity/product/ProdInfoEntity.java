package com.backend.v1.data.entity.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="TBL_PROD_INTRO")
@Data
public class ProdInfoEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private @Column(name="PROD_CD") String prodCode;

	private @Column(name="PROD_INTRO_IMG_PATH") String prodIntroImagePath;
	
	private @Column(name="PROD_INTRO_IMG_NM") String prodIntroImageNm;
	
	@Id
	private @Column(name="SORT_SEQ") int sortSeq;
	
	private @Column(name="USE_YN") String useYn;
	
	private @Column(name="REG_DATE") String regDate;

	private @Column(name="REG_USER_ID") String regUserId;
	
	private @Column(name="MOD_DATE") String modDate;
	
	private @Column(name="MOD_USER_ID") String modUserId;
}
