/**
 * 
 */
package com.exercise.tdd.chat.repository;

import static com.exercise.tdd.chat.testdatabuilder.ChatTestDataBuilder.aChat;
import static com.exercise.tdd.chat.testdatabuilder.MessageTestDataBuilder.aMessage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.exercise.tdd.chat.model.Chat;

/**
 * Se definen las operaciones en base de datos sobre la entidad Chat
 * @author Andres Ceballos Sanchez
 */
@Repository
public class ChatRepository {
	
	/**
	 * Retorna todos los chats registrados en la base de datos
	 * @return
	 */
	public List<Chat> getChats() {
		List<Chat> chats = new ArrayList<>();
		chats.add(aChat().build());
		chats.add(aChat().with(aMessage().withDescription("No keyword")).build());
		chats.add(aChat().with(aMessage().withDescription("My world")).build());
		return chats;		
	}

}
