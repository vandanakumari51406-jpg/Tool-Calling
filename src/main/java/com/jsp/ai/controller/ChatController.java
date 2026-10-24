package com.jsp.ai.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ai.dto.ChatRequest;

@RestController
public class ChatController {
	
	@Autowired
	ChatClient chatClient; //comes from external library
	
	@PostMapping(value="/ask")
	public String chat(@RequestBody ChatRequest chatRequest) {
		return chatClient.prompt()
				         .user(chatRequest.getMessage())
				         .call()
				         .content();
	}

}
