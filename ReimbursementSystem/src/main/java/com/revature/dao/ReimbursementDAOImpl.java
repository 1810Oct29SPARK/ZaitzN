package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	
	private EmployeeDAO e = new EmployeeDAOImpl();
	private StatusDAO s = new StatusDAOImpl();

	private static final String filename = "connection.properties";
	public void addReimbursement(Reimbursement r) {
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "INSERT INTO REIMBURSEMENTS (REIMB_ID, REIMB_AMOUNT, REIMB_DESC, EMPLOYEEID, REIMB_STATUS, REIMB_RESOLVER) " +  
					"VALUES(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r.getId());
			pstmt.setDouble(2, r.getAmount());
			pstmt.setString(3, r.getDescription());
			pstmt.setInt(4, r.getEmployeeId().getId());
			pstmt.setInt(5, r.getStatusId().getId());
			pstmt.setInt(6, r.getResolverId().getId());
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException f) {
			f.printStackTrace();
		}
	}
	
	public void updateReimbursement(Reimbursement r, int status, int id) {
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "UPDATE REIMBURSEMENTS " + 
					"SET REIMB_RESOLVER = ?, REIMB_STATUS = ? " + 
					"WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, status);
			pstmt.setInt(3, r.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException f) {
			f.printStackTrace();
		}
	}
	
	public void deleteReimbursementById(int id) {
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "DELETE FROM REIMBURSEMENTS " + 
						"WHERE REIMB_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException f) {
			f.printStackTrace();
		}
	}
	
	public List<Reimbursement> getAllReimbursements(){
		List<Reimbursement> r = new ArrayList<Reimbursement>();
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT R.REIMB_ID, R.REIMB_AMOUNT, R.REIMB_DESC, R.EMPLOYEEID, E.FIRSTNAME, E.LASTNAME, R.REIMB_STATUS, S.STATUS_TITLE, R.REIMB_RESOLVER " + 
						"FROM REIMBURSEMENTS R INNER JOIN EMPLOYEE E ON R.EMPLOYEEID = E.EMPLOYEEID " +
						"INNER JOIN REIMB_STATUS S ON R.REIMB_STATUS = S.STATUS_ID ORDER BY R.REIMB_ID";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reimbId = rs.getInt("REIMB_ID");
				double amount = rs.getDouble("EMPLOYEE_ID");
				String reimbDesc = rs.getString("REIMB_DESC");
				int employeeId = rs.getInt("EMPLOYEEID");
				int status = rs.getInt("REIMB_STATUS");
				int resolver = rs.getInt("REIMB_RESOLVER");
				r.add(new Reimbursement(reimbId, amount, reimbDesc, e.getEmployeeById(employeeId), s.getStatusById(status), e.getEmployeeById(resolver)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException f) {
			f.printStackTrace();
		}
	return r;
	}
	
	
	public Reimbursement getReimbursementById(int id) {
		Reimbursement r = null;
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE REIMB_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reimbId = rs.getInt("REIMB_ID");
				double amount = rs.getDouble("EMPLOYEE_ID");
				String reimbDesc = rs.getString("REIMB_DESC");
				int employeeId = rs.getInt("EMPLOYEEID");
				int status = rs.getInt("REIMB_STATUS");
				int resolver = rs.getInt("REIMB_RESOLVER");
				r = (new Reimbursement(reimbId, amount, reimbDesc, e.getEmployeeById(employeeId), s.getStatusById(status), e.getEmployeeById(resolver)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException f) {
			f.printStackTrace();
		}
	return r;
	}
	
	public List<Reimbursement> getReimbursementsByEmpId(Employee em){
		List<Reimbursement> list = new ArrayList<Reimbursement>();
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT REIMB_ID, REIMB_AMOUNT, REIMB_DESC, EMPLOYEEID, REIMB_STATUS, REIMB_RESOLVER " + 
						"FROM REIMBURSEMENTS WHERE EMPLOYEEID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, em.getId());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reimbId = rs.getInt("REIMB_ID");
				double amount = rs.getDouble("EMPLOYEE_ID");
				String reimbDesc = rs.getString("REIMB_DESC");
				int employeeId = rs.getInt("EMPLOYEEID");
				int status = rs.getInt("REIMB_STATUS");
				int resolver = rs.getInt("REIMB_RESOLVER");
				list.add(new Reimbursement(reimbId, amount, reimbDesc, e.getEmployeeById(employeeId), s.getStatusById(status), e.getEmployeeById(resolver)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException f) {
			f.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateReimbursement(Reimbursement r, int employeeId) {
		// TODO Auto-generated method stub
		
	}


}
