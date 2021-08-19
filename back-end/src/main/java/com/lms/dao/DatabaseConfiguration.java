package com.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

public class DatabaseConfiguration {
public static Connection getConnection() {
String jdbcURL = "jdbc:mysql://localhost:3306/testdb";
	
	String dbusername = "shashank";
	String dbpassword = "jhashank@4";
	
	try {
		 return DriverManager.getConnection(jdbcURL,dbusername,dbpassword);
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	return null;
}
}
