/**
 * 
 */
package com.exercise.tdd.chat.repository;

import static com.exercise.tdd.chat.testdatabuilder.MessageTestDataBuilder.aMessage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.exercise.tdd.chat.model.Message;

/**
 * Valida las consultas en base de datos de la entidad Message
 * 
 * @author Andres Ceballos Sanchez
 */
@RunWith(MockitoJUnitRunner.class)
public class MessageRepositoryTest {
	
	@InjectMocks
	private MessageRepository messageRepository;
	
	@Test
	public void getMessages() {
		// Arrange
		List<Message> expectedMessages = new ArrayList<>();		
		expectedMessages.add(aMessage().build());
		expectedMessages.add(aMessage().withUser("Wrong user!").build());
		expectedMessages.add(aMessage().withUser("Another user!").build());

		// Act
		List<Message> actualMessages = messageRepository.getMessages();

		// Assert
		assertNotNull(actualMessages);
		assertEquals(expectedMessages, actualMessages);
	}

}
