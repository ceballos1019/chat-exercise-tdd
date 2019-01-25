/**
 * 
 */
package com.exercise.tdd.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.tdd.chat.model.Message;
import com.exercise.tdd.chat.service.MessageService;

/**
 * Expone las operaciones para la consulta de mensajes
 * @author Andre Ceballos Sanchez
 */
@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@GetMapping("/messages")
	public List<Message> getMessagesByUser(@RequestParam("user") String user) {
		return this.messageService.getMessagesByUser(user);
	}
}
