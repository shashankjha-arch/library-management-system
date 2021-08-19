package com.lms.controller;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lms.dto.BookDetails;
import com.lms.dto.BookInventory;
import com.lms.dto.StaffDetails;
import com.lms.dto.UserDetails;
import com.lms.service.LmsService;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/LMS")
public class LmsController {
	@Autowired
	LmsService service;
	
@PostMapping(path = "/registermember", consumes = "application/json" )
	 boolean registerUser(@RequestBody UserDetails userdetail) throws SQLException {
		return service.registerUser(userdetail);
	}

@PostMapping(path = "/registerstaff", consumes = "application/json")	
boolean registerStaff(@RequestBody StaffDetails staffdetail) {
	return service.registerStaff(staffdetail);
}

@GetMapping(path = "/deactivatemember", produces = "application/json")	
	 boolean  deactivateMember(@RequestParam String registrationnumber) throws SQLException {
	
		return service.deactivateMember(registrationnumber);
	}


@GetMapping(path = "/withdrawbook", produces = "application/json")	
      boolean withdrawBook(@RequestParam String bookname , @RequestParam String registrationnumber) throws SQLException {
	BookDetails book = new BookDetails();
	book.setBookName(bookname);
	book.setRegistrationnumber(registrationnumber);
	System.out.println(book);
		return service.withdrawBook(book);
	}

@PostMapping(path = "/depositebook", consumes = "application/json")	
	 boolean depositeBook(@RequestBody BookDetails book) throws SQLException {
	System.out.println("---");
		return service.depositeBook(book);
	}


@PostMapping(path = "/bookreissue", produces = "application/json")	
	 BookDetails bookReissue(@RequestParam BookDetails book) {
		return service.bookReissue(book);
	}

@PostMapping(path = "/addbookininventory", consumes = "application/json")		
	boolean addBookInInventory(@RequestBody BookInventory bookpresent) throws SQLException {
		return service.addBookInInventory(bookpresent);
	}

@GetMapping(path = "/removebookfrominventory", produces = "application/json")	
	boolean removeBookFromInventory(@RequestParam String bookname) throws SQLException {
		return service.removeBookFromInventory(bookname);
	}

@PostMapping(path = "/membershipcard", produces = "application/json")		
	 boolean issueMembershipCard(@RequestParam UserDetails user) throws SQLException {
		return service.issueMembershipCard(user);
	}
	

@GetMapping(path = "/checkUserLogin", produces = "application/json")	
    UserDetails  checkUserLogin(@RequestParam String email) throws SQLException {
	    return service.checkUserLogin(email);
    }

@GetMapping(path = "/checkAdminLogin", produces = "application/json")	
    StaffDetails  checkAdminLogin(@RequestParam String email) throws SQLException {
	    return service.checkAdminLogin(email);
    }

@GetMapping(path = "/bookavailability", produces = "application/json")
    BookInventory checkBookAvailability(@RequestParam String bookId) throws SQLException {
        return service.checkBookAvailability(bookId); 
    }

@GetMapping(path = "/searchBook", produces = "application/json")
    List<String> searchBook(@RequestParam String bookname) throws SQLException {
       return service.searchBook(bookname); 
    }

@GetMapping(path = "/searchUser", produces = "application/json")
List<String> searchUser(@RequestParam String registrationnumber) throws SQLException {
	System.out.println("Received request for reg no "+registrationnumber);
   return service.searchUser(registrationnumber); 
}

@GetMapping(path = "/bookList", produces = "application/json")
List<String> searchBookfromInventory(@RequestParam String bookname) throws SQLException {
   return service.searchBookfromInventory(bookname); 
}

 }
