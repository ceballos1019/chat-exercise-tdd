/**
 * 
 */
package com.exercise.tdd.chat.testdatabuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.exercise.tdd.chat.model.Chat;
import com.exercise.tdd.chat.model.Message;
import static com.exercise.tdd.chat.testdatabuilder.MessageTestDataBuilder.aMessage;

/**
 * @author andressanchez
 *
 */
public class ChatTestDataBuilder {
	
	private Date createDate;
	private List<Message> messages;
	
	public ChatTestDataBuilder() {
		this.createDate = new Date(10000l);
		with(aMessage());
	}
	
	public ChatTestDataBuilder withCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
	
	public ChatTestDataBuilder with(MessageTestDataBuilder...messages) {
		this.messages = new ArrayList<>();
		for(MessageTestDataBuilder message: messages) {
			this.messages.add(message.build());
		}
		return this;
	}
	
	public Chat build() {
		return new Chat(this.createDate, this.messages);
	}
	
	public static ChatTestDataBuilder aChat() {
		return new ChatTestDataBuilder();
	}
	
}
