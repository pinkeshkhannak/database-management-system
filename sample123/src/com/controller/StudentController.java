package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.daoImpl.StudentDaoImpl;
import com.model.Student;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao dao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new StudentDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter( "action" );
		
		if(action != null) {
		
			if (action.equalsIgnoreCase("listStudent")) {
				request.setAttribute("students", dao.getAllStudents() );
				RequestDispatcher view = request.getRequestDispatcher("/listStudent.jsp");
				view.forward(request, response);
			}else if (action.equalsIgnoreCase("insert")) {
				
				RequestDispatcher view = request.getRequestDispatcher("/insert.jsp");
				view.forward(request, response);
				
		}
	}
		else{
			
			String firstname = request.getParameter( "firstname" );
			String lastname = request.getParameter( "lastname" );
			String course = request.getParameter( "course" );
			String year = request.getParameter( "year" );
			
			Student studentobj = new Student();
			studentobj.setFirstName(firstname);
			studentobj.setLastName(lastname);
			studentobj.setCourse(course);
			studentobj.setYear(Integer.parseInt(year));
			
			dao.addStudent(studentobj);
			
			RequestDispatcher view = request.getRequestDispatcher("/success.jsp");
			view.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
