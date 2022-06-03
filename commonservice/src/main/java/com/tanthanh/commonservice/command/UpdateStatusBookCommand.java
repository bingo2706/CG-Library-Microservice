package com.tanthanh.commonservice.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateStatusBookCommand {

	@TargetAggregateIdentifier
	private String bookId;
	private Boolean isReady;
	
	
	
	public UpdateStatusBookCommand(String bookId, Boolean isReady) {
		super();
		this.bookId = bookId;
		this.isReady = isReady;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Boolean getIsReady() {
		return isReady;
	}
	public void setIsReady(Boolean isReady) {
		this.isReady = isReady;
	}
	
	
}
