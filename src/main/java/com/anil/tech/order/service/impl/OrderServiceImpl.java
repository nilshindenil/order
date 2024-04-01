package com.anil.tech.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.tech.order.dto.OrderDto;
import com.anil.tech.order.dto.OrderLineItemsDto;
import com.anil.tech.order.model.Order;
import com.anil.tech.order.model.OrderLineItems;
import com.anil.tech.order.repository.OrderRepository;
import com.anil.tech.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public OrderDto placeOrder(OrderDto orderDto) {
		Order order = new Order();
		
		order.setId(orderDto.getId());
		order.setOrderNumber(orderDto.getOrderNumber());
		
		List<OrderLineItems> orderLineItemsList = orderDto.getOrderLineItems().stream().map(orderLineItemsDto -> mapToOrderLineItems(orderLineItemsDto)).toList();
		order.setOrderLineItems(orderLineItemsList);
		Order orderResult = orderRepository.save(order);
		return mapToOrderDto(orderResult);
	}

	private OrderDto mapToOrderDto(Order order) {
		OrderDto orderDto = new OrderDto();
		if (order != null) {
			orderDto.setId(order.getId());
			orderDto.setOrderNumber(order.getOrderNumber());
			orderDto.setOrderLineItems(order.getOrderLineItems().stream().map(orderLineItems -> mapToDto(orderLineItems)).toList());
			return orderDto;
		}
		return null;
	}
	
	private OrderLineItemsDto mapToDto(OrderLineItems orderItems) {
		OrderLineItemsDto orderItemsDto = new OrderLineItemsDto();
		orderItemsDto.setId(orderItems.getId());
		orderItemsDto.setPrice(orderItems.getPrice());
		orderItemsDto.setQuantity(orderItems.getQuantity());
		orderItemsDto.setSkuCode(orderItems.getSkuCode());
		return orderItemsDto;
	}
	private OrderLineItems mapToOrderLineItems(OrderLineItemsDto lineItemsDto) {
		OrderLineItems orderItems = new OrderLineItems();
		
		orderItems.setId(lineItemsDto.getId());
		orderItems.setPrice(lineItemsDto.getPrice());
		orderItems.setQuantity(lineItemsDto.getQuantity());
		orderItems.setSkuCode(lineItemsDto.getSkuCode());
		return orderItems;
		
	}

	@Override
	public OrderDto getOrderById(Integer id) {
		Order order = null;
		if(orderRepository.findById(id).isPresent()) {
			order = orderRepository.findById(id).get();
			return mapToOrderDto(order);
		}
		return null;
	} 
}
