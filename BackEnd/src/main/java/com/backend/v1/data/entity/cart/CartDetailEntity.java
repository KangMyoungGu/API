package com.backend.v1.data.entity.cart;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="TBL_CART_DETAIL")
@Data
public class CartDetailEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private @Column(name="CART_CD") String cartCd;
	private @Column(name="PROD_CD") String prodCd;
	private @Column(name="PROD_COLOR_CD") String prodColorCd;
	private @Column(name="PROD_SIZE_CD") String prodSizeCd;
	private @Column(name="PROD_COUNT") int prodCount;
	private @Column(name="PROD_PRICE") int prodPrice;
	private @Column(name="SORT") int sort;
}
