package com.regnant.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBCRUDOperations {
	Connection connection=GetDBConnection.getDBConnection();
	Statement stmt;
	PreparedStatement pstmt;
	public int createStudent(Student student) {		
		int rows_count =0;
		try {
//			stmt=connection.createStatement();
//			String insertQuery="insert sample.student_tbl values('"+student.getId()+"','"+student.getName()+"','"+student.getMail()+"')";
								//insert sample.student_tbl values(4,"Trinadh","Trinadh@gmail.com");
//			rows_count=stmt.executeUpdate(insertQuery);
			String insertQuery="insert sample.student_tbl values(?,?,?)";
			pstmt=connection.prepareStatement(insertQuery);
			pstmt.setInt(1,student.getId());
			pstmt.setString(2,student.getName());
			pstmt.setString(3, student.getMail());
			rows_count=pstmt.executeUpdate();
						
		}catch(SQLException e) {
			System.out.println("SQL Exception in insert");
			e.printStackTrace();
		}
		return rows_count;
	}
	public int updateStudent(Student student) {
		int rows_count=0;
		try {
			//stmt=connection.createStatement();
			String updateQuery="update sample.student_tbl set name=?,mail=? where id=?";
			pstmt=connection.prepareStatement(updateQuery);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getMail());
			pstmt.setInt(3,student.getId() );
			rows_count=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("SQL Exception in update");
			e.printStackTrace();
		}
		return rows_count;
	}
	public int deleteStudent(Student student) {
		int rows_count=0;
		try {
			//stmt=connection.createStatement();
			String deleteQuery="delete from sample.student_tbl where id=?";
			pstmt=connection.prepareStatement(deleteQuery);
			pstmt.setInt(1, student.getId());
			rows_count=pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("SQL Execption in Delete");
			e.printStackTrace();
		}
		return rows_count;
	}
	public List<Student> retrieveStudent(){
		List<Student> studentlist=new ArrayList<>();
		ResultSet rs;
		try {
			stmt=connection.createStatement();
			rs=stmt.executeQuery("select * from sample.student_tbl");
			while(rs.next()) {
				Student s=new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setMail(rs.getString(3));
				studentlist.add(s);
			}
			connection.close();
			
		}catch(SQLException e) {
			System.out.println("SQL Exception in Select");
			e.printStackTrace();
		}
		return studentlist;
	}
	
}
