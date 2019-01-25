/**
 * 
 */
package com.exercise.tdd.chat.testdatabuilder;

import java.util.Date;

import com.exercise.tdd.chat.model.Message;

/**
 * @author andressanchez
 *
 */
public class MessageTestDataBuilder {
	
	private Date date;
	private String description;
	private String user;
	
	public MessageTestDataBuilder() {
		this.date = new Date(2000l);
		this.description = "Hello world!";
		this.user = "ancsanc";
	}
	
	public MessageTestDataBuilder withDate(Date date) {
		this.date = date;
		return this;
	}
	
	public MessageTestDataBuilder withDescription(String description) {
		this.description = description;
		return this;
	}
	
	public MessageTestDataBuilder withUser(String user) {
		this.user = user;
		return this;
	}

	public Message build() {
		return new Message(this.date, this.description, this.user);
	}
	
	public static MessageTestDataBuilder aMessage() {
		return new MessageTestDataBuilder();
	}

}
