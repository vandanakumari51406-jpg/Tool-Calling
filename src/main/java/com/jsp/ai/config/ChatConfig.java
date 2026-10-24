package com.jsp.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.jsp.ai.tools.OrderTools;

@Configuration
public class ChatConfig {
	
	// you are an ai assistant from my e commerce application
	//use findOrderstatus when user ask for status of the order and provides the order id 
	// use createOrder when user ask for create or place order and provide product name, price, orderId
	// Use processGetPost when user ask to get the posts
	//if product name,order id, price not provided
	//ask the user self, you can ask normal question
	
	//practice with diff llms
	
	@Bean
	public ChatClient getChatClient(ChatModel chatModel, OrderTools orderTools) {
		
		return ChatClient.builder(chatModel)
				.defaultTools(orderTools)
				.defaultSystem("you are an ai assistant from my e commerce application\r\n"
						+ "	use findOrderstatus when user ask for status of the order and provides the order id \r\n"
						+ "	use createOrder when user ask for create or place order and provide product name, price, orderId\r\n"
						+ "	Use processGetPost when user ask to get the posts\r\n"
						+ "	if product name,order id, price not provided\r\n"
						+ "	ask the user self, you can ask normal question\r\n"
						+ "	")
				.build();
	}
	
	@Bean
	public WebClient getWebClient() {
		return WebClient.builder().build();
	}
	

}
