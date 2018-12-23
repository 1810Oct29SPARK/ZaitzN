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
	@Override
	public int addReimbursement(double amount, String desc, int id) {
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "INSERT INTO REIMBURSEMENTS (REIMB_AMOUNT, REIMB_DESC, EMPLOYEEID, REIMB_STATUS) " +  
					"VALUES(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, amount);
			pstmt.setString(2, desc);
			pstmt.setInt(3, id);
			pstmt.setInt(4, 1);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException f) {
			f.printStackTrace();
		}
		return -1;
	}
	
	@Override
	public void updateReimbursement(int rId, int status, int id) {
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "UPDATE REIMBURSEMENTS " + 
					"SET REIMB_RESOLVER = ?, REIMB_STATUS = ? " + 
					"WHERE REIMB_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, status);
			pstmt.setInt(3, rId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException f) {
			f.printStackTrace();
		}
	}
	
	@Override
	public int deleteReimbursementById(int id) {
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "DELETE FROM REIMBURSEMENTS " + 
						"WHERE REIMB_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException f) {
			f.printStackTrace();
		}
		return -1;
	}
	
	@Override
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
				double amount = rs.getDouble("REIMB_AMOUNT");
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
	
	@Override
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
	
	@Override
	public List<Reimbursement> getReimbursementsByEmpId(int id){
		List<Reimbursement> list = new ArrayList<Reimbursement>();
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT REIMB_ID, REIMB_AMOUNT, REIMB_DESC, EMPLOYEEID, REIMB_STATUS, REIMB_RESOLVER " + 
						"FROM REIMBURSEMENTS WHERE EMPLOYEEID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reimbId = rs.getInt("REIMB_ID");
				double amount = rs.getDouble("REIMB_AMOUNT");
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

}
