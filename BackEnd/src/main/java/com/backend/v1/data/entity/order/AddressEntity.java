package com.backend.v1.data.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "tbl_address")
public class AddressEntity {
	
	@Id
	@Column(name = "ADDR_CD")
	private String addrCode;
		
	@Column(name = "ADDR_USER_CD")
	private String addrUserCD;	//USER 테이블과의 FK
	
	@Column(name = "ZIPCODE")
	private String zipCode;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "ADDRESS_DETAIL")
	private String addressDetail;
	
	@Column(name = "REG_DATE")
	private String regDate;
	
	@Column(name = "MODE_DATE")
	private String modDate;
}
