package com.lms.dto;

public class BookInventory {
	
	//variable declaration.
	String bookName;
	String bookId;
	String bookAuthor;
	String publication;
	String edition;
	Boolean bookAvailability;
	int bookCount;
	
	//Getter and setter methods for above declared variable.
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	public Boolean getBookAvailability() {
		return bookAvailability;
	}
	public void setBookAvailability(Boolean bookAvailability) {
		this.bookAvailability = bookAvailability;
	}
	
	public int getBookCount() {
		return bookCount;
	}
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	
	@Override
	public String toString() {
		return "BookInventory [bookName=" + bookName + ", bookId=" + bookId + ", bookAuthor=" + bookAuthor
				+ ", publication=" + publication + ", Edition=" + edition + ", bookAvailability=" + bookAvailability
				+ ", bookCount=" + bookCount + "]";
	}
	
}
