package com.anil.tech.order.model;

import java.util.List;

import com.anil.tech.order.dto.OrderLineItemsDto;

public class OrderRequest {

	List<OrderLineItemsDto> orderLineItemsDtosList;

	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderRequest(List<OrderLineItemsDto> orderLineItemsDtosList) {
		super();
		this.orderLineItemsDtosList = orderLineItemsDtosList;
	}

	public List<OrderLineItemsDto> getOrderLineItemsDtosList() {
		return orderLineItemsDtosList;
	}

	public void setOrderLineItemsDtosList(List<OrderLineItemsDto> orderLineItemsDtosList) {
		this.orderLineItemsDtosList = orderLineItemsDtosList;
	}
	
}
