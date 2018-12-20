package com.revature.beans;

public class Employee {

	public Employee(int id, String firstName, String lastName, String email, Role roleId, String userName, String password) {
		
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = roleId;
		this.userName = userName;
		this.password = password;
	}
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private Role roleId;
	private String userName;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRoleId() {
		return roleId;
	}
	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", roleId=" + roleId + ", userName=" + userName + ", password=" + password + "]";
	}
	
}
