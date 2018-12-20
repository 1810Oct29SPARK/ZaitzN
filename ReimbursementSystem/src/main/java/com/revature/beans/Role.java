package com.revature.beans;

public class Role {

	public Role(int roleId, String roleName) {
		super();
		this.id = roleId;
		this.roleName = roleName;
	}
	private int id;
	private String roleName;
	public int getRoleId() {
		return id;
	}
	public void setRoleId(int roleId) {
		this.id = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + id + ", roleName=" + roleName + "]";
	}
	

}
