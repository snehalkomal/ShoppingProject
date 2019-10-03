package com.ltil.services;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltil.utilities.ConnectionManager;


@WebServlet("/PreRegistrationServlet")
public class PreRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection connection=null;   
   
    public PreRegistrationServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		connection=ConnectionManager.getConnection();
		
		RequestDispatcher rd=request.getRequestDispatcher("RegistrationForm.jsp");
		rd.forward(request, response);
		//response.sendRedirect("RegistrationForm.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
