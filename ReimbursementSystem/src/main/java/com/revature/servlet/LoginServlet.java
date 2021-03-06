package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Credentials;
import com.revature.beans.Employee;
import com.revature.service.AuthenticationService;
import com.revature.service.BusinessDelegate;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4008501494161108628L;
	
	AuthenticationService authService = new AuthenticationService();
	BusinessDelegate bd = new BusinessDelegate();

	//return login page for get request
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
	
	//handle POST request from form on login page
	//(or anywhere else)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("handling request...");
		
		//checks whether a session exists, otherwise creates a new one
		//overloaded version takes a boolean create param, if false it returns null if no session exists for the current request
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		//grab params from request
		Credentials c = new Credentials(req.getParameter("username"), req.getParameter("password"));
		Employee u = authService.isValidEmployee(c);
		System.out.println(u);
		if (u != null) {
			session.setAttribute("username", u.getUserName());
			session.setAttribute("firstName", u.getFirstName());
			session.setAttribute("lastName", u.getLastName());
			session.setAttribute("id", u.getId());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("roleId", u.getRoleId().getRoleId());
			session.setAttribute("roleTitle", u.getRoleId().getRoleName());
			resp.sendRedirect("profile");
			
		} else {
			session.setAttribute("problem", "invalid credentials");
			session.invalidate();
			resp.sendRedirect("login");
		}

	}

}
