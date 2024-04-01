package com.anil.tech.order.dto;

import java.math.BigDecimal;

public class OrderLineItemsDto {

	private Integer id;
	private String skuCode;
	private BigDecimal price;
	private Integer quantity;
	public OrderLineItemsDto(Integer id, String skuCode, BigDecimal price, Integer quantity) {
		super();
		this.id = id;
		this.skuCode = skuCode;
		this.price = price;
		this.quantity = quantity;
	}
	public OrderLineItemsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
