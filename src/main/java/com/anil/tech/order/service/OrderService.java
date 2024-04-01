package com.anil.tech.order.service;

import com.anil.tech.order.dto.OrderDto;


public interface OrderService {

	OrderDto placeOrder(OrderDto orderDto);
	OrderDto getOrderById(Integer id);
}
