package com.revature.beans;

import java.util.Arrays;

public class Reimbursement {

	public Reimbursement(int id, double amount, String description, byte[] blob, Employee employeeId, Status statusId,
			Employee resolverId) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.blob = blob;
		this.employeeId = employeeId;
		this.statusId = statusId;
		this.resolverId = resolverId;
	}
	
	private int id;
	private double amount;
	private String description;
	private byte[] blob;
	private Employee employeeId;
	private Status statusId;
	private Employee resolverId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getBlob() {
		return blob;
	}
	public void setBlob(byte[] blob) {
		this.blob = blob;
	}
	public Employee getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}
	public Status getStatusId() {
		return statusId;
	}
	public void setStatusId(Status statusId) {
		this.statusId = statusId;
	}
	public Employee getResolverId() {
		return resolverId;
	}
	public void setResolverId(Employee resolverId) {
		this.resolverId = resolverId;
	}
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", description=" + description + ", blob="
				+ Arrays.toString(blob) + ", employeeId=" + employeeId + ", statusId=" + statusId + ", resolverId="
				+ resolverId + "]";
	}

}
