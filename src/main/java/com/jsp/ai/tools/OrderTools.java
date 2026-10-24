package com.jsp.ai.tools;

import java.math.BigInteger;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.ai.Service.OrderService;
import com.jsp.ai.entity.OrderEntity;

@Component
public class OrderTools {
	
	
	@Autowired
	private OrderService orderService;
	
	@Tool(description = "Get the status of an order when user provides the order id")
	public String findOrderStatus(
			@ToolParam(description = "Order ID")
			BigInteger orderId) {
		return orderService.processOrderStatus(orderId);
	}
	
	@Tool(description = "Create new order"
			+"call this method only when user provides"
			+"product name, price and orderId")
	public void createOrder(
			@ToolParam(description = "Product name")String productName,
			@ToolParam(description = "Price")Long price,
			@ToolParam(description = "Order ID")BigInteger orderId) {
	
		
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderId(orderId);
		orderEntity.setPrice(price);
		orderEntity.setProductName(productName);
		orderEntity.setOrderStatus("PENDING");
		orderService.processCreateOrder(orderEntity);
		
	//	return orderService.processCreateOrder(order);
	}
	
	@Tool(description = "Get the post details")
	public String processGetPost() {
		return orderService.processGetPost();
	}

}
