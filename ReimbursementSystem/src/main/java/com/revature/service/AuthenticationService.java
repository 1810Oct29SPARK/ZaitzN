package com.revature.service;

import com.revature.beans.Credentials;
import com.revature.beans.Employee;
import com.revature.beans.Role;

public class AuthenticationService {

	public AuthenticationService() {
	}

	public Employee isValidEmployee(Credentials credentials) {
		// take credentials and return the User to which they belong if it exists
		Employee u = null;
		String username = credentials.getUsername();
		String password = credentials.getPassword();
		// this is AUTHENTICATION (does the user exist in the system?)
		// now AUTHORIZATION (what can the user access within the system?) (user roles)

		BusinessDelegate bd = new BusinessDelegate();
		u = bd.getEmployeeByUsername(username);

		return u;

	}

}
