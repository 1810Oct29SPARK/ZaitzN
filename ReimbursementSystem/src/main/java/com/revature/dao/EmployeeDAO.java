package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();
	public Employee getEmployeeById(int id);
	public Employee getEmployeeByUserAndPass(String username, String password);
	
}
