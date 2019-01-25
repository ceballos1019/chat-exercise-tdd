/**
 * 
 */
package com.exercise.tdd.chat.service;

import static com.exercise.tdd.chat.testdatabuilder.ChatTestDataBuilder.aChat;
import static com.exercise.tdd.chat.testdatabuilder.MessageTestDataBuilder.aMessage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.exercise.tdd.chat.model.Chat;
import com.exercise.tdd.chat.repository.ChatRepository;

/**
 * Valida toda la logica de negocio sobre las consultas de chats
 * 
 * @author Andres Ceballos Sanchez
 */
@RunWith(MockitoJUnitRunner.class)
public class ChatServiceTest {

	@InjectMocks
	private ChatService chatService;

	@Mock
	private ChatRepository chatRepository;

	/**
	 * Valida que se retornen los chats esperados cuando se envia una palabra clave
	 */
	@Test
	public void getChatsByKeyword() {
		// Arrange
		String keyword = "world";
		List<Chat> expectedChats = new ArrayList<>();
		expectedChats.add(aChat().build());
		expectedChats.add(aChat().with(aMessage().withDescription("My world")).build());

		List<Chat> repositoryResponse = new ArrayList<>();
		repositoryResponse.add(aChat().build());
		repositoryResponse.add(aChat().with(aMessage().withDescription("No keyword")).build());
		repositoryResponse.add(aChat().with(aMessage().withDescription("My world")).build());
		when(this.chatRepository.getChats()).thenReturn(repositoryResponse);

		// Act
		List<Chat> actualChats = this.chatService.getChatsByKeyword(keyword);

		// Assert
		assertNotNull(actualChats);
		assertEquals(expectedChats, actualChats);
	}

	/**
	 * Valida que se retorne al menos un chat cuando se busca por palabra clave
	 */
	@Test
	public void getChatsByKeywordSize() {
		// Arrange
		String keyword = "world";
		List<Chat> expectedChats = new ArrayList<>();
		expectedChats.add(aChat().build());
		expectedChats.add(aChat().with(aMessage().withDescription("My world")).build());

		List<Chat> repositoryResponse = new ArrayList<>();
		repositoryResponse.add(aChat().build());
		repositoryResponse.add(aChat().with(aMessage().withDescription("No keyword")).build());
		repositoryResponse.add(aChat().with(aMessage().withDescription("My world")).build());
		when(this.chatRepository.getChats()).thenReturn(repositoryResponse);

		// Act
		List<Chat> actualChats = this.chatService.getChatsByKeyword(keyword);

		// Assert
		assertNotNull(actualChats);
		assertTrue(actualChats.size() > 0);
	}
}
