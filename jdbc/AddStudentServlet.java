package com.regnant.jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("AddStudentServlet.doGet()");
		
		int id=Integer.parseInt(request.getParameter("StudentID"));
		String name=request.getParameter("StudentName");
		String mail=request.getParameter("StudentMail");
		
		System.out.println(id+"  "+name+"  "+mail);
		
		DBCRUDOperations dbop=new DBCRUDOperations();
		Student student=new Student();
		
		student.setId(id);
		student.setName(name);
		student.setMail(mail);
		int row_insert=dbop.createStudent(student);
		List<Student> slist=dbop.retrieveStudent();
		request.setAttribute("event", slist);
		
		System.out.println(row_insert);
		request.getRequestDispatcher("ListStudent.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
