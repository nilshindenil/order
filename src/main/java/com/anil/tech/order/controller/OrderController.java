package com.anil.tech.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.tech.order.dto.OrderDto;
import com.anil.tech.order.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/place")
	public ResponseEntity<OrderDto> placeOrder(@RequestBody OrderDto orderDto){
	
		try {
			OrderDto orderDtoResult = orderService.placeOrder(orderDto);
			if (orderDtoResult == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<OrderDto>(orderDtoResult, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") Integer id){
		try {
			OrderDto orderDto = orderService.getOrderById(id);
			if(orderDto == null) {
				return new ResponseEntity<OrderDto>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<OrderDto>(orderDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<OrderDto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
