/**
 * 
 */
package com.exercise.tdd.chat.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.tdd.chat.model.Message;
import com.exercise.tdd.chat.repository.MessageRepository;

/**
 * Define la logica de negocio para las consultas de mensajes
 * @author Andres Ceballos Sanchez
 */
@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	/**
	 * Retorna la lista de mensajes filtrados por usuario
	 * @param user - usuario a buscar
	 * @return Lista de mensajes
	 */
	public List<Message> getMessagesByUser(String user) {
		List<Message> allMessages = this.messageRepository.getMessages();
		 return allMessages.stream().filter(msg -> msg.getUser().equals(user)).collect(Collectors.toList());		
	}

}
