/**
 * 
 */
package com.exercise.tdd.chat.controller;

import static com.exercise.tdd.chat.testdatabuilder.ChatTestDataBuilder.aChat;
import static com.exercise.tdd.chat.testdatabuilder.MessageTestDataBuilder.aMessage;
import static org.mockito.Mockito.when;
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
import static org.hamcrest.Matchers.hasSize;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.exercise.tdd.chat.model.Chat;
import com.exercise.tdd.chat.service.ChatService;

/**
 * Valida las operaciones que se exponen en el controlador de Chat
 * @author Andres Ceballos Sanchez
 *
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ChatControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private ChatController chatController;
	
	@Mock
	private ChatService chatService;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(chatController).build();
		Whitebox.setInternalState(chatController, "chatService", chatService);
	}
	
	/**
	 * Valida que se retorne un arreglo con los chats y del tamaño esperado
	 * @throws Exception
	 */
	@Test
	public void getChatsByKeyword() throws Exception {
		//Arrange
		String keyword = "world";
		List<Chat> serviceResponse = new ArrayList<>();
		serviceResponse.add(aChat().build());
		serviceResponse.add(aChat().with(aMessage().withDescription("My world")).build());
		
		List<Chat> expectedChats = new ArrayList<>();
		expectedChats.add(aChat().build());
		expectedChats.add(aChat().with(aMessage().withDescription("My world")).build());
		int expectedSize = expectedChats.size();
		when(chatService.getChatsByKeyword(keyword)).thenReturn(serviceResponse);
		
		//Act
		ResultActions result = mockMvc.perform(get("/chats").param("keyword", keyword));
		
		//Assert
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$").isArray());
		result.andExpect(jsonPath("$", hasSize(expectedSize)));
	}

}
