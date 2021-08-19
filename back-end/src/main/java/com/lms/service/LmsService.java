package com.lms.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dao.LmsDao;
import com.lms.dto.BookDetails;
import com.lms.dto.BookInventory;
import com.lms.dto.StaffDetails;
import com.lms.dto.UserDetails;

@Service
public class LmsService {
	@Autowired
	LmsDao lmsDao;
	public  boolean registerUser(UserDetails userdetail) throws SQLException {
		return lmsDao.insertUser(userdetail);
	}
	
	public boolean deactivateMember(String registration_number) throws SQLException {
		return lmsDao.deleteUser(registration_number);
	}
	
	public boolean withdrawBook(BookDetails book) throws SQLException {
		BookInventory bookInv = selectBookInventory(book.getBookName());
		book.setBookId(bookInv.getBookId());
		book.setBookAuthor(bookInv.getBookAuthor());
		book.setPublication(bookInv.getPublication());
		book.setEdition(bookInv.getEdition());
		if(bookInv.getBookCount()==1) {
		lmsDao.updateBookCount(bookInv.getBookName(),-1);
		}else {
			lmsDao.updateBookCount(bookInv.getBookName(),bookInv.getBookCount()-1);
		}
		return lmsDao.insertBook(book);
	}
	
	public boolean depositeBook(BookDetails book) throws SQLException {
		BookInventory books = new BookInventory();
		books.setBookName(book.getBookName());
		books.setBookId(book.getBookId());
		books.setEdition(book.getEdition());
		books.setPublication(book.getPublication());
		boolean result = lmsDao.deleteBook(book.getBookName(), book.getRegistrationnumber());
		if(result) {
		addBookInInventory(books);
		}
		return result;
	}
	
	public UserDetails selectUser(String registrationnumber) {
		return lmsDao.selectUser(registrationnumber);
	}
	public BookDetails bookReissue(BookDetails book) {
		return lmsDao.updateBook(book);
	}
	
	public boolean addBookInInventory(BookInventory bookpresent) throws SQLException {
		int bookCount = getBookCountfromInventory(bookpresent.getBookName());
		if(bookCount==0) {
			return lmsDao.insertBookInventory(bookpresent);
		}else if(bookCount==-1) {
			lmsDao.updateBookCount(bookpresent.getBookName(), bookCount+2);
			return true;
		}
		
		else {
			lmsDao.updateBookCount(bookpresent.getBookName(), bookCount+1);
			 return true;
		}
		
	}
	
	public boolean removeBookFromInventory(String bookname) throws SQLException {
		return lmsDao.deleteBookInventory(bookname);
		
	}
	
	public boolean issueMembershipCard(UserDetails user) throws SQLException {
		return lmsDao.insertUser(user);
	}
	
	public boolean registerStaff(StaffDetails staffdetail) {
		return lmsDao.insertStaff(staffdetail);
	}
	
	public UserDetails checkUserLogin(String email) throws SQLException {
		
	return lmsDao.checkUserLogin(email);
    }
	
	public StaffDetails checkAdminLogin(String email) throws SQLException {
		return lmsDao.checkAdminLogin(email);
	}
	
	public BookInventory checkBookAvailability(String bookId) throws SQLException {
		return lmsDao.checkBookAvailability(bookId);
	}
	
	public List<String> searchBook(String bookname) throws SQLException {
		return lmsDao.searchBook(bookname);
	}
	public BookInventory selectBookInventory(String bookname) throws SQLException {
		System.out.println(bookname);
		return lmsDao.selectBookInventory(bookname);
	}
	
	public List<String> searchUser(String registrationnumber) throws SQLException {
		return lmsDao.searchUser(registrationnumber);
	}
	
	public List<String> searchBookfromInventory(String bookname) throws SQLException {
		return lmsDao.searchBookfromInventory(bookname);
	}
	
	public int getBookCountfromInventory(String bookname) throws SQLException{
		return lmsDao.bookCountinInventory(bookname);
		
	}
	
	
}
