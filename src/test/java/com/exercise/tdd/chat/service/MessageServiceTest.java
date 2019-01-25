/**
 * 
 */
package com.exercise.tdd.chat.service;

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

import com.exercise.tdd.chat.model.Message;
import com.exercise.tdd.chat.repository.MessageRepository;

/**
 * @author andressanchez
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {

	@InjectMocks
	private MessageService messageService;

	@Mock
	private MessageRepository messageRepository;

	/**
	 * Valida que se retornen los mensajes esperados cuando se envia un usuario
	 * especifico
	 */
	@Test
	public void getMessagesByUser() {
		// Arrange
		String user = "ancsanc";
		List<Message> expectedMessages = new ArrayList<>();
		expectedMessages.add(aMessage().build());

		List<Message> repositoryResponse = new ArrayList<>();
		repositoryResponse.add(aMessage().build());
		repositoryResponse.add(aMessage().withUser("Wrong user!").build());
		repositoryResponse.add(aMessage().withUser("Another user!").build());
		when(this.messageRepository.getMessages()).thenReturn(repositoryResponse);

		// Act
		List<Message> actualMessages = this.messageService.getMessagesByUser(user);

		// Assert
		assertNotNull(actualMessages);
		assertEquals(expectedMessages, actualMessages);
	}
	
	/**
	 * Valida que se retorne al menos un mensajes cuando se filtra por usuario
	 */
	@Test
	public void getMessagesByUserSize() {
		// Arrange
		String user = "ancsanc";
		List<Message> expectedMessages = new ArrayList<>();
		expectedMessages.add(aMessage().build());

		List<Message> repositoryResponse = new ArrayList<>();
		repositoryResponse.add(aMessage().build());
		repositoryResponse.add(aMessage().withUser("Wrong user!").build());
		repositoryResponse.add(aMessage().withUser("Another user!").build());
		when(this.messageRepository.getMessages()).thenReturn(repositoryResponse);

		// Act
		List<Message> actualMessages = this.messageService.getMessagesByUser(user);

		// Assert
		assertNotNull(actualMessages);
		assertTrue(expectedMessages.size() > 0);
	}

}
