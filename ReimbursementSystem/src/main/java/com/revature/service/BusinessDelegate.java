package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.beans.Status;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.dao.StatusDAO;
import com.revature.dao.StatusDAOImpl;

public class BusinessDelegate {
	
	private EmployeeDAO ed = new EmployeeDAOImpl();
	private ReimbursementDAO rd = new ReimbursementDAOImpl();
	private StatusDAO sd = new StatusDAOImpl();

		public List<Employee> getEmployees() {
			
			 List<Employee> employees = new ArrayList<>();
			employees = ed.getEmployees();
			return employees;
			
		}
		
		public Employee getEmployeeById(int id) {
			
			Employee e = ed.getEmployeeById(id);
			return e;
			
		}
		
		public Employee getEmployeeByUserAndPass(String username, String password) {
			
			Employee e = ed.getEmployeeByUserAndPass(username, password);
			return e;
			
		}
		
		public void addReimbursement(double amount, String desc, int id) {
			rd.addReimbursement(amount, desc, id);
			
		}
		public void updateReimbursement(Reimbursement r, int status, int employeeId) {
			rd.updateReimbursement(r, status, employeeId);
			
		}
		public void deleteReimbursementById(int id) {
			rd.deleteReimbursementById(id);
			
		}
		public List<Reimbursement> getAllReimbursements(){
			List<Reimbursement> reimbs = rd.getAllReimbursements();
			return reimbs;
			
		}
		public Reimbursement getReimbursementById(int id) {
			Reimbursement r = rd.getReimbursementById(id);
			return r;
			
		}
		public List<Reimbursement> getReimbursementsByEmpId(int id){
			
			List<Reimbursement> reimbs = rd.getReimbursementsByEmpId(id);
			return reimbs;
		}
		
		public String getStatusName(int id) {
			Status name = sd.getStatusById(id);
			String actualName = name.getName();
			return actualName;
		}

		
	

}
