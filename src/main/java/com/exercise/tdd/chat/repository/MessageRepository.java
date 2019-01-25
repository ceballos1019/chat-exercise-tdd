/**
 * 
 */
package com.exercise.tdd.chat.repository;

import static com.exercise.tdd.chat.testdatabuilder.MessageTestDataBuilder.aMessage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.exercise.tdd.chat.model.Message;

/**
 * Se implementan las operaciones de consulta de base de datos para la entidad Message
 * @author andressanchez
 *
 */
@Repository
public class MessageRepository {

	/**
	 * Retorna todos los mensajes almacenados en base de datos
	 * @return Lista de mensajes
	 */
	public List<Message> getMessages() {
		List<Message> messages = new ArrayList<>();		
		messages.add(aMessage().build());
		messages.add(aMessage().withUser("Wrong user!").build());
		messages.add(aMessage().withUser("Another user!").build());
		return messages;
	}

}
