/**
 * 
 */
package com.exercise.tdd.chat.repository;

import static com.exercise.tdd.chat.testdatabuilder.ChatTestDataBuilder.aChat;
import static com.exercise.tdd.chat.testdatabuilder.MessageTestDataBuilder.aMessage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.exercise.tdd.chat.model.Chat;

/**
 * Valida las operaciones hacia la base de datos de la entidad Chat
 * @author Andres Ceballos Sanchez
 */
@RunWith(MockitoJUnitRunner.class)
public class ChatRepositoryTest {
	
	@InjectMocks
	private ChatRepository chatRepository;
	
	/**
	 * Valida que se retornen todos los chats registrados en la base de datos
	 */
	@Test
	public void getChats() {
		//Arrange			
		List<Chat> expectedChats = new ArrayList<>();
		Chat firstChat = aChat().build();		
		Chat secondChat = aChat().with(aMessage().withDescription("No keyword")).build();
		Chat thirdChat = aChat().with(aMessage().withDescription("My world")).build();
		expectedChats.add(firstChat);
		expectedChats.add(secondChat);
		expectedChats.add(thirdChat);
		
		//Act
		List<Chat> actualChats = chatRepository.getChats();
		
		//Assert
		assertNotNull(actualChats);
		assertEquals(expectedChats, actualChats);
	}
}
