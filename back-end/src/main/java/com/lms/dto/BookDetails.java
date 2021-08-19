package com.lms.dto;

public class BookDetails {

	// Declared required variables for BookDetails class. 
	String bookName;
	String bookId;
	String bookAuthor;
	String publication;
	String edition;
	String registrationnumber;
	
	//Getter setter methods for above declared variable.
	
	
	public String getRegistrationnumber() {
		return registrationnumber;
	}
	public void setRegistrationnumber(String registrationnumber) {
		this.registrationnumber = registrationnumber;
	}
	
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
	
	@Override
	public String toString() {
		return "BookDetails [bookName=" + bookName + ", bookId=" + bookId + ", bookAuthor=" + bookAuthor
				+ ", publication=" + publication + ", Edition=" + edition + "]";
	}
	
	
}
