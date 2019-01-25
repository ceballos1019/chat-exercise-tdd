/**
 * 
 */
package com.exercise.tdd.chat.controller;

import static com.exercise.tdd.chat.testdatabuilder.MessageTestDataBuilder.aMessage;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.reflect.Whitebox;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.exercise.tdd.chat.model.Message;
import com.exercise.tdd.chat.service.MessageService;

/**
 * Valida las operaciones que se exponen en el controlador para Message
 * @author Andres Ceballos Sanchez
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private MessageController messageController;
	
	@Mock
	private MessageService messageService;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();
		Whitebox.setInternalState(messageController, "messageService", messageService);
	}
	
	@Test
	public void getMessagesByUser() throws Exception {
		//Arrange
		String user = "ancsanc";
		List<Message> serviceResponse = new ArrayList<>();
		serviceResponse.add(aMessage().build());
		
		List<Message> expectedMessages = new ArrayList<>();
		expectedMessages.add(aMessage().build());
		int expectedSize = expectedMessages.size();
		when(messageService.getMessagesByUser(user)).thenReturn(serviceResponse);
		
		//Act
		ResultActions result = mockMvc.perform(get("/messages").param("user", user));
		
		//Assert
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$").isArray());
		result.andExpect(jsonPath("$", hasSize(expectedSize)));
	}
	
}
