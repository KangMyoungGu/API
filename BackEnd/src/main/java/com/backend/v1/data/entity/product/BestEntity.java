package com.backend.v1.data.entity.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="TBL_PROD_BEST")
@Data
public class BestEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="PROD_CD")
	private String prodCode;
	
	@Column(name="EXPOSURE_START_PERIOD")
	private String exposureStartDate;
	
	@Column(name="EXPOSURE_END_PERIOD")
	private String exposureEndDate;

}
