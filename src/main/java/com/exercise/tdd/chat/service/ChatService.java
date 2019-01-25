/**
 * 
 */
package com.exercise.tdd.chat.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.tdd.chat.model.Chat;
import com.exercise.tdd.chat.model.Message;
import com.exercise.tdd.chat.repository.ChatRepository;

/**
 * Define la logica de negocio para las consultas de chats
 * @author Andres Ceballos Sanchez
 */
@Service
public class ChatService {

	@Autowired
	private ChatRepository chatRepository;

	/**
	 * Consulta los chats y los filtra por una palabra clave
	 * @param keyword - palabra clave para filtrar
	 * @return Lista de chats filtrados
	 */
	public List<Chat> getChatsByKeyword(String keyword) {
		List<Chat> allChats = this.chatRepository.getChats();	
		List<Chat> filteredChats = new ArrayList<>();

		for (Chat chat : allChats) {
			Optional<Message> message = chat.getMessages().stream().filter(msg -> msg.getDescription().contains(keyword))
					.findAny();
			if(message.isPresent()) {
				filteredChats.add(chat);
			}

		}
		
		return filteredChats;
	}

}
