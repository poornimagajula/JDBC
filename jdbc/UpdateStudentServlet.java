package com.regnant.jdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UpdateStudentServlet.doGet()");
		int id=Integer.parseInt(request.getParameter("StudentID"));
		String name=request.getParameter("StudentName");
		String mail=request.getParameter("StudentMail");
		
		System.out.println(id+"  "+name+"  "+mail);
		
		DBCRUDOperations dbop=new DBCRUDOperations();
		Student student=new Student();
		
		student.setId(id);
		student.setName(name);
		student.setMail(mail);
		int row_update=dbop.updateStudent(student);
		System.out.println("No of Rows Updated:"+row_update);
		request.getRequestDispatcher("Success.html").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
