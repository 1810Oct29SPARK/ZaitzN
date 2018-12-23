package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.dao.StatusDAO;
import com.revature.dao.StatusDAOImpl;

/**
 * Servlet implementation class ReimbursementServlet
 */
public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ReimbursementDAO rd = new ReimbursementDAOImpl();
	EmployeeDAO ed = new EmployeeDAOImpl();
	StatusDAO sd = new StatusDAOImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			int id = (int) session.getAttribute("id");
			List<Reimbursement> r = rd.getReimbursementsByEmpId(id);
			response.getWriter().write(new ObjectMapper().writeValueAsString(r));
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			double amount = Double.parseDouble(request.getParameter("amount"));
			String desc = request.getParameter("desc");
			int id = (int) session.getAttribute("id");
			response.getWriter().print(rd.addReimbursement(amount, desc, id));
		} else {
			response.sendRedirect("login");
		}
	}

}
