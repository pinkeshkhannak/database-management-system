package com.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.util.Util;

/**
 * Servlet implementation class Roja
 */
@WebServlet("/Roja")
public class Roja extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection conn;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Roja() {
        conn = Util.getConnection();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// if method is get in sample.jsp, type in this block
		response.setContentType("text/html"); 
		
		String yourname = request.getParameter("yourname");
		String yourpass = request.getParameter("yourpass");
		PrintWriter writer = response.getWriter();
		
		//==============================================ADD THIS CODE FOR DATABASE===========================================//
		if(yourname.equals("pink") && yourpass.equals("pink"))
		{
			try {
				String query = "insert into test (name,pass) values (?,?)";
				PreparedStatement preparedStatement = conn.prepareStatement( query );
				preparedStatement.setString( 1, yourname );
				preparedStatement.setString( 1, yourpass );
				preparedStatement.executeUpdate();
				preparedStatement.close();
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			      rd.include(request,response);
			      writer.println("back to servlet");
			} catch (SQLException e) {
				e.printStackTrace();
				writer.println("<h1> Login failed.</h1>");
			}
		}else{
			writer.println("<h1> Login failed.</h1>");
		}
		//==============================================ADD THIS CODE FOR DATABASE===========================================//
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		// TODO Auto-generated method stub
		// if method is post in sample.jsp, type in this block
	}

}
