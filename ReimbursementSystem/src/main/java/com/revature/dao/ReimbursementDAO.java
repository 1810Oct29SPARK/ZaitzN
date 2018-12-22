package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {
	
	public void addReimbursement(Reimbursement r);
	public void updateReimbursement(Reimbursement r, int status, int id);
	public void deleteReimbursementById(int id);
	public List<Reimbursement> getAllReimbursements();
	public Reimbursement getReimbursementById(int id);
	public List<Reimbursement> getReimbursementsByEmpId(Employee e);

}
