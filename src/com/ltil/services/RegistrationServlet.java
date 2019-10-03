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


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection=ConnectionManager.getConnection();
	private UserDao dao=new UserDaoImp();
	//User user=new User();
	private HttpSession session=null;
	
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String uid=request.getParameter("uid");
		String pwd=request.getParameter("password");
		User user=new User(name,uid,pwd);
		//String pwd1=request.getParameter("password1");
		
		
		
	/*	if(pwd==pwd1)
		{	
		User user=new User(name,uid,pwd);
		}
		
		else
		{
			response.getWriter().println("Please enter the correct credentials");
		}*/
		boolean x=dao.addUser(user);
		if(x==true)
		{
			session=request.getSession();
			session.setAttribute("user", user);
			
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
