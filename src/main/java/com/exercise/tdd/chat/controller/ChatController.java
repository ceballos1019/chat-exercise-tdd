/**
 * 
 */
package com.exercise.tdd.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.tdd.chat.model.Chat;
import com.exercise.tdd.chat.service.ChatService;

/**
 * Expone las operaciones para consultar los chats
 * @author Andres Ceballos Sanchez
 */
@RestController
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@GetMapping("/chats")
	public List<Chat> getChatsByKeyword(@RequestParam("keyword") String keyword) {
		return this.chatService.getChatsByKeyword(keyword);
	}
	
}
