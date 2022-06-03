package com.tanthanh.commonservice.events;

public class BookUpdateStatusEvent {
	private String bookId;
	private Boolean isReady;
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
