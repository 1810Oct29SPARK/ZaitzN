package com.revature.dao;

public class Test {

	public static void main(String[] args) {
		
		EmployeeDAO ed = new EmployeeDAOImpl();
		System.out.println(ed.getEmployees());
		System.out.println(ed.getEmployeeById(3));
		
	}

}
