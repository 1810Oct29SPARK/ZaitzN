package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {
	
	public int addReimbursement(double amount, String desc, int id);
	public void updateReimbursement(int rId, int status, int id);
	public int deleteReimbursementById(int id);
	public List<Reimbursement> getAllReimbursements();
	public Reimbursement getReimbursementById(int id);
	public List<Reimbursement> getReimbursementsByEmpId(int id);

}
