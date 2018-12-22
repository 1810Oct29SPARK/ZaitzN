package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;

public class BusinessDelegate {
	
	private EmployeeDAO ed = new EmployeeDAOImpl();

		public List<Employee> getEmployees() {
			
			 List<Employee> employees = new ArrayList<>();
			employees = ed.getEmployees();
			return employees;
			
		}
		
		public Employee getEmployeeById(int id) {
			
			Employee e = ed.getEmployeeById(id);
			return e;
			
		}
		
		public Employee getEmployeeByUsername(String username) {
			
			Employee e = ed.getEmployeeByUsername(username);
			return e;
			
		}
		
	

}
