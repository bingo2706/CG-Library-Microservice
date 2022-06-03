package com.tanthanh.bookservice.command.api.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateBookCommand {
	@TargetAggregateIdentifier
	private String bookId;
	private String name;
	private String author;
	
	
	public UpdateBookCommand(String bookId, String name, String author) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.author = author;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
