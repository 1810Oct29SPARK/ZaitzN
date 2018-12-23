package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Role;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static final String filename = "connection.properties";

	@Override
	public List<Employee> getManagedEmployees() {
		List<Employee> el = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT E.EMPLOYEEID, E.FIRSTNAME, E.LASTNAME, E.EMAIL, E.ROLEID, ER.EMPLOYEE_TITLE FROM EMPLOYEE E " + 
					"INNER JOIN EMPLOYEE_ROLES ER " + 
					"ON ER.EMPLOYEE_ROLEID = 1 AND E.ROLEID = 1 ORDER BY EMPLOYEEID";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("EMPLOYEEID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				int roleId = rs.getInt("ROLEID");
				String title = rs.getString("EMPLOYEE_TITLE");
				String user = null;
				String pass = null;
				el.add(new Employee(id, firstName, lastName, email, new Role(roleId, title), user, pass));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return el;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee em = null;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT E.EMPLOYEEID, E.FIRSTNAME, E.LASTNAME, E.EMAIL, E.ROLEID, ER.EMPLOYEE_TITLE FROM EMPLOYEE E " + 
					"INNER JOIN EMPLOYEE_ROLES ER " + 
					"ON E.ROLEID = ER.EMPLOYEE_ROLEID WHERE E.EMPLOYEEID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int employeeId = rs.getInt("EMPLOYEEID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				int roleId = rs.getInt("ROLEID");
				String title = rs.getString("EMPLOYEE_TITLE");
				String user = null;
				String pass = null;
				em = new Employee(employeeId, firstName, lastName, email, new Role(roleId, title), user, pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return em;
	}

	@Override
	public Employee getEmployeeByUserAndPass(String username, String password) {
		Employee em = null;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT E.EMPLOYEEID, E.FIRSTNAME, E.LASTNAME, E.EMAIL, E.ROLEID, ER.EMPLOYEE_TITLE FROM EMPLOYEE E " + 
					"INNER JOIN EMPLOYEE_ROLES ER " + 
					"ON E.ROLEID = ER.EMPLOYEE_ROLEID WHERE E.EMPLOYEE_USERNAME = ? AND EMPLOYEE_PASSWORD = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int employeeId = rs.getInt("EMPLOYEEID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				int roleId = rs.getInt("ROLEID");
				String title = rs.getString("EMPLOYEE_TITLE");
				String user = null;
				String pass = null;
				em = new Employee(employeeId, firstName, lastName, email, new Role(roleId, title), user, pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return em;
	}



}
