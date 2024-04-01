package com.anil.tech.order.dto;

import java.util.List;

public class OrderDto {
	private Integer id;
	private String orderNumber;
	private List<OrderLineItemsDto> orderLineItemsDto;
	public OrderDto(Integer id, String orderNumber, List<OrderLineItemsDto> orderLineItemsDto) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.orderLineItemsDto = orderLineItemsDto;
	}
	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public List<OrderLineItemsDto> getOrderLineItems() {
		return orderLineItemsDto;
	}
	public void setOrderLineItems(List<OrderLineItemsDto> orderLineItemsDto) {
		this.orderLineItemsDto = orderLineItemsDto;
	}
}
