package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.revature.beans.Status;
import com.revature.util.ConnectionUtil;

public class StatusDAOImpl implements StatusDAO {
	
	private static final String filename = "connection.properties";

	@Override
	public Status getStatusById(int id) {
		Status s = null;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * FROM REIMB_STATUS WHERE STATUS_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int statusId = rs.getInt("STATUS_ID");
				String statusTitle = rs.getString("STATUS_TITLE");
				s = new Status(statusId, statusTitle);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}


}
