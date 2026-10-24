package com.jsp.ai.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ai.Service.OrderService;
import com.jsp.ai.entity.OrderEntity;


@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping(value = "/creatOrder")
	public String createOrder(@RequestBody OrderEntity orderEntity) {
		return orderService.processCreateOrder(orderEntity);
	}

	
	@GetMapping(value ="/status/{orderId}")
	public String getOrderStatus(@PathVariable("orderId")BigInteger orderId) {
		return orderService.processOrderStatus(orderId);
	}
}
