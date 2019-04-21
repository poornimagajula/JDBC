package com.regnant.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetDBConnection {
	public static Connection getDBConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","Admin@123");
		} catch (ClassNotFoundException e) {
			System.out.println("where is your MySQL JDBC Driver");
			e.printStackTrace();
			return null;
		
		}catch(SQLException e) {
			System.out.println("Connection Failed check output console");
			e.printStackTrace();
			return null;
		}
		return connection;
		
	}
}
