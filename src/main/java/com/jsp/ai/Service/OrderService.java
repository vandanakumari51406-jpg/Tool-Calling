package com.jsp.ai.Service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.jsp.ai.entity.OrderEntity;
import com.jsp.ai.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	WebClient webClient;
	
	public String processCreateOrder(OrderEntity entity) {
		orderRepository.save(entity);
	return "Order created successfully";
   }

public String processOrderStatus(BigInteger orderId) {
        Optional<OrderEntity> optional=orderRepository.findById(orderId);

       OrderEntity orderEntity = optional.get();
       return orderEntity.getOrderStatus();
   }

public void processCancelOrder(BigInteger orderId) {
	
}
public String processGetPost() {
	return webClient.get()
			.uri("https://jsonplaceholder.typicode.com/posts")
			.retrieve()
			.bodyToMono(String.class)
			.block();
	
}
}