package com.revature.dao;

import com.revature.service.BusinessDelegate;

public class Test {

	public static void main(String[] args) {
		BusinessDelegate bd = new BusinessDelegate();
		EmployeeDAO ed = new EmployeeDAOImpl();
		System.out.println(ed.getManagedEmployees());
		System.out.println(ed.getEmployeeById(3));
		
	}

}
