package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.dao.StatusDAO;
import com.revature.dao.StatusDAOImpl;

@WebServlet("/deny")
public class DenyServlet extends HttpServlet{

	/**
	 * 
	 */
	ReimbursementDAO rd = new ReimbursementDAOImpl();
	EmployeeDAO ed = new EmployeeDAOImpl();
	StatusDAO sd = new StatusDAOImpl();
	
	private static final long serialVersionUID = -3975523520170159129L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String stuff = request.getReader().readLine();
			int id = stuff.charAt(stuff.length() - 3) - '0';
			int eid = (int) session.getAttribute("id");
			rd.updateReimbursement(id, 3, eid);
		}
	}
}
