package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lms.dto.BookDetails;
import com.lms.dto.BookInventory;
import com.lms.dto.StaffDetails;
import com.lms.dto.UserDetails;

@Component
public class LmsDao {
	

	//Method for user insertion.
	public boolean insertUser(UserDetails user) throws SQLException {
		boolean flag = false;
		Connection connection=null;
		try {
			String sql = " INSERT INTO UserDetail (firstname, lastname, email, gender, dateofbirth, registrationnumber,membershipstartingdate,membershipendingdate,contactnumber,address,isactive,password)" +
	             	" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
			 connection=DatabaseConfiguration.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			
			statement.setString(1, user.getFirstname());
			statement.setString(2, user.getLastname());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getGender());
			statement.setTimestamp(5, user.getDate_of_birth());
			statement.setString(6, user.getRegistration_number());
			statement.setTimestamp(7, user.getMembership_Starting_date());
			statement.setTimestamp(8, calculateEndingDate(user.getMembership_Starting_date()));
			statement.setLong(9, user.getContact_number());
			statement.setString(10, user.getAddress());
			statement.setBoolean(11, user.isActive());
			statement.setString(12, user.getPassword());
			
			int rows = statement.executeUpdate();
			
			if(rows > 0) {
				flag = true;
				System.out.println("A new user has been inserted successfully");
			}
			
			if(connection!=null) {
				System.out.println("Connected to the database.");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return flag;
	}
	private Timestamp calculateEndingDate(Timestamp membership_Starting_date) {
		Instant instant
        = membership_Starting_date.toInstant();
    Instant value
        = instant.plus(365, ChronoUnit.DAYS);
    Timestamp current = Timestamp.from(value);

		return current;
	}
	//method for staff insertion.
	public boolean insertStaff(StaffDetails staff) {
		boolean flag = false;
		try {
			String sql = " INSERT INTO StaffDetail(employeeid, firstname, lastname, email, gender, dateofbirth, jobjoiningdate,contactnumber,address,isactive,password)" +
	             	" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
			Connection connection=DatabaseConfiguration.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, staff.getEmployeeId());
			statement.setString(2, staff.getFirstname());
			statement.setString(3, staff.getLastname());
			statement.setString(4, staff.getEmail());
			statement.setString(5, staff.getGender());
			statement.setTimestamp(6, staff.getDate_of_birth());
			statement.setTimestamp(7, staff.getJob_Starting_date());
			statement.setLong(8, staff.getContact_number());
			statement.setString(9, staff.getAddress());
			statement.setBoolean(10, staff.getIsActive());
			statement.setString(11, staff.getPassword());
			
			int rows = statement.executeUpdate();
			
			if(rows > 0) {
				flag = true;
				System.out.println("A new staff has been inserted successfully");
			}
			
			if(connection!=null) {
				System.out.println("Connected to the database.");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	//Method for book insertion.
	public boolean insertBook(BookDetails book) throws SQLException {
		boolean flag = false;
		Connection connection=null;
		try {
			String sql = " INSERT INTO BookDetail(bookid, bookname, bookauthor, bookpublication, bookedition, registrationnumber)" +
	             	" VALUES(?, ?, ?, ?, ?, ?)";
			 connection=DatabaseConfiguration.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, book.getBookId());
			statement.setString(2, book.getBookName());
			statement.setString(3, book.getBookAuthor());
			statement.setString(4, book.getPublication());
			statement.setString(5, book.getEdition());
			statement.setString(6, book.getRegistrationnumber());
			
			int rows = statement.executeUpdate();
			
			if(rows > 0) {
				flag = true;
				System.out.println("A new book has been inserted successfully");
			}
			
			if(connection!=null) {
				System.out.println("Connected to the database.");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return flag;
	}
	
	//method for book inventory insertion(book count, availability).
	public boolean insertBookInventory(BookInventory bookpresent) {
		boolean flag = false;
		try {
			String sql = " INSERT INTO BookInventory(bookid, bookname, bookauthor, bookpublication, bookedition,bookcount)" +
	             	" VALUES(?, ?, ?, ?, ?, ?)";
			Connection connection=DatabaseConfiguration.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, bookpresent.getBookId());
			statement.setString(2, bookpresent.getBookName());
			statement.setString(3, bookpresent.getBookAuthor());
			statement.setString(4, bookpresent.getPublication());
			statement.setString(5, bookpresent.getEdition());
			statement.setInt(6, 1);
			
			int rows = statement.executeUpdate();
			
			if(rows > 0) {
				flag = true;
				System.out.println("Book count has been inserted successfully");
			}
			
			if(connection!=null) {
				System.out.println("Connected to the database.");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	//Method for user selection.
	public UserDetails selectUser(String registrationnumber) {
		 UserDetails user = new UserDetails();
		 Connection connection=null;
		try {
			
	        String sql = "SELECT * from UserDetail where registrationnumber = "+ registrationnumber;
			 connection=DatabaseConfiguration.getConnection();
	       java.sql.Statement statement = connection.createStatement();
	       ResultSet result = statement.executeQuery(sql);
	       
	      
	       while(result.next()) {
	    	 user.setFirstname(result.getString("firstname"));
	    	 user.setLastname( result.getString("lastname")) ;
	    	 user.setEmail(result.getString("email")); 
	    	 user.setGender(result.getString("gender"));
	    	 user.setDate_of_birth(result.getTimestamp("dateofbirth"));
	    	 user.setRegistration_number(result.getString("registrationnumber"));
	    	 user.setMembership_Starting_date(result.getTimestamp("membershipstartingdate"));
	    	 user.setMembership_Ending_date(result.getTimestamp("membershipendingdate"));
	    	 user.setContact_number(result.getInt("contactnumber"));
	    	 user.setAddress(result.getString("address"));
	    	 user.setActive(result.getBoolean("isactive"));
	    	 
	    	
	       }
	        
			
		}catch(SQLException e) {
		e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}
	
	
		
	
	//Method for staff selection
	public StaffDetails selectStaff(String employeeId) {
		StaffDetails staff = new StaffDetails();
		
          try {
			
	        String sql = "SELECT * from StaffDetail where employeeid = "+ employeeId;
			Connection connection=DatabaseConfiguration.getConnection();
	        java.sql.Statement statement = connection.createStatement();
	        ResultSet result = statement.executeQuery(sql);
	       
	      
	       while(result.next()) {
	    	 staff.setEmployeeId(result.getString("employeeid"));
	    	 staff.setFirstname(result.getString("firstname"));
	    	 staff.setLastname( result.getString("lastname")) ;
	    	 staff.setEmail(result.getString("email")); 
	    	 staff.setGender(result.getString("gender"));
	    	 staff.setDate_of_birth(result.getTimestamp("dateofbirth"));
	    	 staff.setJob_Starting_date(result.getTimestamp("jobjoiningdate"));
	    	 staff.setContact_number(result.getInt("contactnumber"));
	    	 staff.setAddress(result.getString("address"));
	    	 staff.setIsActive(result.getBoolean("isactive"));
	    	
	       }
			
		}catch(SQLException e) {
		e.printStackTrace();
		}
		
		return staff;
		
	}
	
	//Method for book inderion.
	public BookDetails selectBook(String bookname) {
		BookDetails book = new BookDetails();
		
		 try {
				
		        String sql = "SELECT * from BookDetail where bookname = ?";
				Connection connection=DatabaseConfiguration.getConnection();   
		       PreparedStatement statement  =  connection.prepareStatement(sql);
		       
		        statement.setString(1, book.getBookName());
				ResultSet result = statement.executeQuery();
		        while(result.next()) {
		    	book.setBookId(result.getString("bookid"));
		    	book.setBookName(result.getString("bookname"));
		    	book.setBookAuthor( result.getString("bookauthor")) ;
		    	book.setPublication(result.getString("bookpublication")); 
		    	book.setEdition(result.getString("bookedition"));
		    	
		       }
				
			}catch(SQLException e) {
			e.printStackTrace();
			}
		
		return book;
		
	}
	
	//Method for book inventory selection.
	public BookInventory selectBookInventory(String bookname) throws SQLException {
		System.out.println("Method started");
	    BookInventory bookinventory = new BookInventory();
	    Connection connection =null;
	    try {
			
	        String sql = "SELECT * from BookInventory where bookname = ?";
			 connection=DatabaseConfiguration.getConnection();
	        PreparedStatement statement  =  connection.prepareStatement(sql);
		       
	        statement.setString(1, bookname);
	        ResultSet result = statement.executeQuery();
	       
	      
	       while(result.next()) {
	    	 bookinventory.setBookId(result.getString("bookid"));
	    	 bookinventory.setBookName(result.getString("bookname"));
	    	 bookinventory.setBookAuthor( result.getString("bookauthor")) ;
	    	 bookinventory.setPublication(result.getString("bookpublication")); 
	    	 bookinventory.setEdition(result.getString("bookedition"));
	    	 bookinventory.setBookCount(result.getInt("bookcount"));
	    	
	    	
	       }
			
		}catch(SQLException e) {
		e.printStackTrace();
		}finally {
			connection.close();
		}
		System.out.println("Method ended");
		return bookinventory;
		
	}
	
	//Method for user update.
	public UserDetails updateUser(UserDetails user) throws SQLException {
		Connection connection=null;
		try {
	        
			String sql = "update UserDetail set username = ? , firstname = ?, lastname = ?, email = ?, gender = ?, dateofbirth = ?, membershipstartingdate = ?, membershipendingdate = ?, contactnumber = ?, address = ?, isactive = ? , password = ? where registrationnumber = ?";
			
			connection=DatabaseConfiguration.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, user.getFirstname());
			statement.setString(2, user.getLastname());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getGender());
			statement.setTimestamp(5, user.getDate_of_birth());
			statement.setTimestamp(6, user.getMembership_Starting_date());
			statement.setTimestamp(7, user.getMembership_Ending_date());
			statement.setLong(8, user.getContact_number());
			statement.setString(9, user.getAddress());
			statement.setBoolean(10, user.isActive());
			statement.setString(11, user.getRegistration_number());
			statement.setString(12, user.getPassword());

			int rows = statement.executeUpdate(sql);
			
			if(rows > 0) {
				System.out.println("The user's information has been Updated");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		
		return user;
	}
	
	//Method for staff update.
	public StaffDetails updateStaff(StaffDetails staff) {
       try {
	        
			String sql = "update UserDetail set firstname = ?, lastname = ?, email = ?, gender = ?, dateofbirth = ?, membershipstartingdate = ?, membershipendingdate = ?, contactnumber = ?, address = ?, isactive = ? where employeeid = ?";
			
			Connection connection=DatabaseConfiguration.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, staff.getFirstname());
			statement.setString(2, staff.getLastname());
			statement.setString(3, staff.getEmail());
			statement.setString(4, staff.getGender());
			statement.setTimestamp(5, staff.getDate_of_birth());
			statement.setTimestamp(6, staff.getJob_Starting_date());
			statement.setLong(7, staff.getContact_number());
			statement.setString(8, staff.getAddress());
			statement.setBoolean(9, staff.getIsActive());
			statement.setString(10, staff.getEmployeeId());
					

			int rows = statement.executeUpdate(sql);
			
			if(rows > 0) {
				System.out.println("The staff's information has been Updated");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
return staff;
		
	}
	
	//Method for book update.
	public BookDetails updateBook(BookDetails book) {
	
		try {
	        
			String sql = "update users set bookname = ? , bookauthor = ?, bookpublication = ?, bookedition where bookid = ?";
			
			Connection connection=DatabaseConfiguration.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, book.getBookName());
			statement.setString(2, book.getBookAuthor());
			statement.setString(3, book.getPublication());
			statement.setString(4, book.getEdition());
			statement.setString(5, book.getBookId());
			
			int rows = statement.executeUpdate(sql);
			
			if(rows > 0) {
				System.out.println("The Book's information has been Updated");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return book;
	}
	
	//Method for book inventory update.
	public BookInventory updateBookInventory(BookInventory bookinventory) {
	
      try {
	        
			String sql = "update users set bookname = ? , bookauthor = ?, bookpublication = ?,bookedition = ?, bookcount = ?  where bookid = ?";
			
			Connection connection=DatabaseConfiguration.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, bookinventory.getBookName());
			statement.setString(2, bookinventory.getBookAuthor());
			statement.setString(3, bookinventory.getPublication());
			statement.setString(4, bookinventory.getEdition());
			
			statement.setInt(5, bookinventory.getBookCount());
			statement.setString(6, bookinventory.getBookId());
			
			int rows = statement.executeUpdate(sql);
			
			if(rows > 0) {
				System.out.println("The Book inventory's information has been Updated");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return bookinventory;
		
	}
	
	//Method for user deletion.
	public boolean deleteUser(String Registration_Number) throws SQLException {
		boolean flag = false;
		Connection connection = null;
			try {
				String sql = "DELETE from UserDetail WHERE registrationnumber = ? ";
				
				connection=DatabaseConfiguration.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, Registration_Number);
				
				int rows = statement.executeUpdate();
						if(rows>0) {
							flag = true;
							System.out.println("The user's information has been deleted.");
							
						}

			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				connection.close();
			}
			return flag;
		}
	
	//Method for staff deletion.
	public boolean deleteStaff(String employeeId) {
		boolean flag = false;
			try {
				String sql = "DELETE from StaffDetail WHERE employeeid = ? ";
				
				Connection connection=DatabaseConfiguration.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, employeeId);
				
				int rows = statement.executeUpdate();
						if(rows>0) {
							flag = true;
							System.out.println("The staff's information has been deleted.");
							
						}

			}catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}
	
	//Method for book deletion.
	public boolean deleteBook(String bookname, String registrationnumber) throws SQLException {
		boolean flag = false;
		Connection connection=null;
			try {
				String sql = "DELETE from BookDetail WHERE bookname = ? and registrationnumber = ? ";
				
				connection=DatabaseConfiguration.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, bookname);
				statement.setString(2, registrationnumber);
				
				int rows = statement.executeUpdate();
						if(rows>0) {
							flag = true;
							System.out.println("The book has been deleted.");
							
						}

			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				connection.close();
			}
			return flag;
		}
	
	//Method for book inventory deletion.
	 public boolean deleteBookInventory(String bookname) throws SQLException {
		boolean flag = false;
		Connection connection=null;
			try {
				String sql = "DELETE from BookInventory WHERE bookname = ? ";
				
				connection=DatabaseConfiguration.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, bookname);
				
				int rows = statement.executeUpdate();
						if(rows>0) {
							flag = true;
							System.out.println("The book inventory has been deleted.");
							
						}

			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				connection.close();
			}
			return flag;
		}
	 
	// Method to check user login.
		public UserDetails checkUserLogin(String email) throws SQLException {
			 UserDetails user = new UserDetails();
			 Connection connection=null;
			try {
				
		        String sql = "SELECT * from UserDetail where email = ?";
		        
			   connection=DatabaseConfiguration.getConnection();
		       PreparedStatement statement = connection.prepareStatement(sql);
		       
		       statement.setString(1, email);
		       ResultSet result = statement.executeQuery();
		       
		      
		       while(result.next()) {
		    	 user.setFirstname(result.getString("firstname"));
		    	 user.setLastname( result.getString("lastname")) ;
		    	 user.setEmail(result.getString("email")); 
		    	 user.setGender(result.getString("gender"));
		    	 user.setDate_of_birth(result.getTimestamp("dateofbirth"));
		    	 user.setRegistration_number(result.getString("registrationnumber"));
		    	 user.setMembership_Starting_date(result.getTimestamp("membershipstartingdate"));
		    	 user.setMembership_Ending_date(result.getTimestamp("membershipendingdate"));
		    	 user.setContact_number(result.getLong("contactnumber"));
		    	 user.setAddress(result.getString("address"));
		    	 user.setActive(result.getBoolean("isactive"));
		    	 user.setPassword(result.getString("password"));
		    	 
		    	
		       }
		        
				
			}catch(SQLException e) {
			e.printStackTrace();
			}finally {
				connection.close();
			}
			user.setDateDiff(calculateDateDiff(user.getMembership_Ending_date(), Instant.now()));
			return user;
		}
		
		private int calculateDateDiff(Timestamp membership_Ending_date, Instant instant) {
		// TODO Auto-generated method stub
		return (int) ChronoUnit.DAYS.between( instant,membership_Ending_date.toInstant());
	}
		// Method to check staff login.
		public StaffDetails checkAdminLogin(String email) throws SQLException {
			 StaffDetails staff = new StaffDetails();
			 Connection connection = null;
				try {
					
			        String sql = "SELECT * from StaffDetail where email = ?";
			       
				   connection=DatabaseConfiguration.getConnection();
			       PreparedStatement statement = connection.prepareStatement(sql);
			       
			       statement.setString(1, email);
			       ResultSet result = statement.executeQuery();
			       
			      
			       while(result.next()) {
			    	     staff.setEmployeeId(result.getString("employeeid"));
				    	 staff.setFirstname(result.getString("firstname"));
				    	 staff.setLastname( result.getString("lastname")) ;
				    	 staff.setEmail(result.getString("email")); 
				    	 staff.setGender(result.getString("gender"));
				    	 staff.setDate_of_birth(result.getTimestamp("dateofbirth"));
				    	 staff.setJob_Starting_date(result.getTimestamp("jobjoiningdate"));
				    	 staff.setContact_number(result.getLong("contactnumber"));
				    	 staff.setAddress(result.getString("address"));
				    	 staff.setIsActive(result.getBoolean("isactive"));
				    	 staff.setPassword(result.getString("password"));
			    	 
			    	
			       }
			        
					
				}catch(SQLException e) {
				e.printStackTrace();
				}
				finally {
					connection.close();
				}
				return staff;
			}
			
		public BookInventory checkBookAvailability(String bookid) throws SQLException {
			 BookInventory bookinventory = new BookInventory();
				try {
					
			        String sql = "SELECT * from BookInventory where bookid = ?";
			       
					Connection connection=DatabaseConfiguration.getConnection();
			       PreparedStatement statement = connection.prepareStatement(sql);
			       
			       statement.setString(1, bookid);
			       ResultSet result = statement.executeQuery();
			       
			      
			       while(result.next()) {
			    	     bookinventory.setBookId(result.getString("bookid"));
				    	 bookinventory.setBookName(result.getString("bookname"));
				    	 bookinventory.setBookAuthor( result.getString("bookauthor")) ;
				    	 bookinventory.setPublication(result.getString("bookpublication")); 
				    	 bookinventory.setEdition(result.getString("bookedition"));
				    	 bookinventory.setBookAvailability(result.getBoolean("bookavailability"));
				    	 bookinventory.setBookCount(result.getInt("bookcount"));
			    	 
			       }
					
				}catch(SQLException e) {
				e.printStackTrace();
				}
				finally {
				}
				return bookinventory;
			}
		// Method to search book.
		public List<String> searchBook(String bookname) throws SQLException {
			List<String> books = new ArrayList<String>();
				try {
					bookname=bookname+"%";
			        String sql = "SELECT * from BookInventory where bookname like ?";
			        
					Connection connection=DatabaseConfiguration.getConnection();
			       PreparedStatement statement = connection.prepareStatement(sql);
			       
			       statement.setString(1, bookname);
			       ResultSet result = statement.executeQuery();
			       
			      
			       while(result.next()) {
			    	     
			    	     books.add(result.getString("bookname"));
			    	    
			       }
					
				}catch(SQLException e) {
				e.printStackTrace();
				}
				finally {
				}
				return books;
			}
			
		public List<String> searchUser(String registrationnumber) throws SQLException {
			
			List<String> users = new ArrayList<String>();
			Connection connection=null;
				try {
					registrationnumber=registrationnumber+"%";
					System.out.println(registrationnumber);
			        String sql = "SELECT * from UserDetail where registrationnumber like ?";
			        
			       connection=DatabaseConfiguration.getConnection();
			       PreparedStatement statement = connection.prepareStatement(sql);
			       
			       statement.setString(1, registrationnumber);
			       ResultSet result = statement.executeQuery();
			       
			      
			       while(result.next()) {
			    	     
			    	     users.add(result.getString("registrationnumber"));
			    	    
			       }
					
				}catch(SQLException e) {
				e.printStackTrace();
				}
				finally {
					connection.close();
				}
				return users;
			}
			
public List<String> searchBookfromInventory(String bookname) throws SQLException {
			
			List<String> book = new ArrayList<String>();
			Connection connection=null;
				try {
					bookname=bookname+"%";
			        String sql = "SELECT * from BookInventory where bookname like ? and bookcount>0";
			        
			       connection=DatabaseConfiguration.getConnection();
			       PreparedStatement statement = connection.prepareStatement(sql);
			       
			       statement.setString(1, bookname);
			       ResultSet result = statement.executeQuery();
			       
			      
			       while(result.next()) {
			    	     
			    	     book.add(result.getString("bookname"));
			    	    
			       }
					
				}catch(SQLException e) {
				e.printStackTrace();
				}
				finally {
					connection.close();
				}
				return book;
			}
			
public int bookCountinInventory(String bookname) throws SQLException {
	
	int count = 0;
	Connection connection=null;
		try {
	        String sql = "SELECT bookcount from BookInventory where bookname = ?";
	        
	       connection=DatabaseConfiguration.getConnection();
	       PreparedStatement statement = connection.prepareStatement(sql);
	       
	       statement.setString(1, bookname);
	       ResultSet result = statement.executeQuery();
	       
	      
	       while(result.next()) {
	    	     
	    	    count = result.getInt("bookcount");
	    	    
	       }
			
		}catch(SQLException e) {
		e.printStackTrace();
		}
		finally {
			connection.close();
		}
		return count;
	}

public void updateBookCount(String bookname,int count) throws SQLException {
	
	Connection connection=null;
		try {
	        String sql = "update BookInventory set bookcount=? where bookname = ?";
	        
	       connection=DatabaseConfiguration.getConnection();
	       PreparedStatement statement = connection.prepareStatement(sql);
	       statement.setInt(1, count);
	       statement.setString(2, bookname);
	       //ResultSet result = statement.executeQuery();
	       statement.executeUpdate();
	       
	      
	       
		}catch(SQLException e) {
		e.printStackTrace();
		}
		finally {
			connection.close();
		}
	}


	
}
