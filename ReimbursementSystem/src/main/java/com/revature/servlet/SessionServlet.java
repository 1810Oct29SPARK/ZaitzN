package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.beans.Role;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6035723100739982453L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// grab current session, if it exists
		HttpSession session = request.getSession(false);
		if (session != null) {
			try {
				int id = (int) session.getAttribute("id");
				String firstname = session.getAttribute("firstName").toString();
				String lastname = session.getAttribute("lastName").toString();
				String email = session.getAttribute("email").toString();
				Employee e = new Employee(id, firstname, lastname, email, new Role(1, "Employee"), null, null);
				response.getWriter().write(new ObjectMapper().writeValueAsString(e));

			} catch (Exception e) {
				response.getWriter().write("{\"session\":null}");
			}
		} 
	}
}
