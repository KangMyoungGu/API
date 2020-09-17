package com.backend.v1.data.entity.cart;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="TBL_CART_MASTER")
@Data
public class CartMasterEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private @Column(name="CART_CD") String cartCd;
	private @Column(name="USER_ID") String userId;
	private @Column(name="USER_NO") String userNo;
	private @Column(name="CART_TOTAL_COUNT") int cartTotalCount;
	private @Column(name="CART_TOTAL_PRICE") int cartTotalPrice;
	private @Column(name="CART_REG_DATE") Date cartRegDate;
	private @Column(name="CART_EXP_DATE") Date cartExpDate;
	private @Column(name="CART_EXP_YN") String cartExpYn;

}
