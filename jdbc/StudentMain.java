package com.regnant.jdbc;

import java.util.List;

public class StudentMain {

	public static void main(String[] args) {
		
		Student s=new Student();
		s.setId(5);
		s.setName("Trinadh");
		s.setMail("Trinadh@gmail.com");
		
		DBCRUDOperations dbop=new DBCRUDOperations();
		
		int row_count=dbop.createStudent(s);
		System.out.println("No of Rows Inserted into Database:"+row_count);
		
		s.setMail("Sai@gmail.com");
		s.setId(1);
		int row_count_update=dbop.updateStudent(s);
		System.out.println("No of rows updated into database:"+row_count_update);
		
		s.setId(6);
		int row_count_delete=dbop.deleteStudent(s);
		System.out.println("No of rows deleted into database:"+row_count_delete);
		
		List<Student> studentlist = dbop.retrieveStudent();
		for(Student student : studentlist) {
			System.out.println(student);
		}	

	}

}
