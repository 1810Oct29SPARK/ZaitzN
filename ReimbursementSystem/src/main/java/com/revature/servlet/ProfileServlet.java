package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8343002811379165553L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//check whether a session exists for the incoming request
		HttpSession session = req.getSession(false);
		if (session != null && (int)session.getAttribute("roleId") == 1) {
			req.getRequestDispatcher("profile.html").forward(req, resp);
		} else if (session != null && (int)session.getAttribute("roleId") == 2){
			req.getRequestDispatcher("profile2.html").forward(req, resp);
		} else {
			resp.sendRedirect("login");
		}
	}

}
