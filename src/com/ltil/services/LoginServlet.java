package com.ltil.services;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ltil.dao.UserDao;
import com.ltil.dao.UserDaoImp;
import com.ltil.model.User;
import com.ltil.utilities.ConnectionManager;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection=null;
	private User user=new User();
	private UserDao dao=new UserDaoImp();
	private HttpSession session=null;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		connection=ConnectionManager.getConnection();
		String usid=request.getParameter("uid1");
		String pwd=request.getParameter("pass");
		
		if(dao.validateUser(user))
		{
			session=request.getSession();
			session.setAttribute("user", user);
			
			RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);
		}
		
		else
		{
			response.getWriter().println("<h1>Invalid Credentials....Try Again</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		
		
		
		
	}

}
