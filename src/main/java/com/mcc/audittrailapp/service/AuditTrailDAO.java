package com.mcc.audittrailapp.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mcc.audittrailapp.connection.GetConnection;
import com.mcc.audittrailapp.model.AuditTrail;

@Service
public class AuditTrailDAO {

	public boolean addAuditTrail(AuditTrail auditTrail) {
		try {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
			String sql = "INSERT INTO audittrail (id, config_id, name, previousvalue, newvalue, date) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ps.setInt(1, auditTrail.getId());
			ps.setInt(2, auditTrail.getConfig_id());
			ps.setString(3, auditTrail.getName());
			ps.setString(4, auditTrail.getPreviousvalue());
			ps.setString(5, auditTrail.getNewvalue());
			//ps.setString(6, auditTrail.getTimestamp());
			ps.setString(6, timeStamp);

			return ps.executeUpdate() > 0;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<AuditTrail> getAllAuditTrail() {
		try {
			List<AuditTrail> audittrailList = new ArrayList<>();
			String sql = "SELECT * FROM audittrail";
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					if (i > 1)
						System.out.print(",  ");
					String columnValue = rs.getString(i);
					System.out.print(columnValue + " " + rs.getMetaData().getColumnName(i));
				}
				System.out.println("");
				AuditTrail audittrail = new AuditTrail();
				audittrail.setId(rs.getInt("id"));
				audittrail.setConfig_id(rs.getInt("config_id"));
				audittrail.setName(rs.getString("name"));
				audittrail.setNewvalue(rs.getString("newvalue"));
				audittrail.setPreviousvalue(rs.getString("previousvalue"));
				audittrail.setDate(rs.getString("date"));

				audittrailList.add(audittrail);
			}
			return audittrailList;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<AuditTrail> getAuditTrailByName(String name) {
		try {
			List<AuditTrail> audittrailList = new ArrayList<>();
			String sql = "SELECT * FROM audittrail WHERE name=?";
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ps.setString(1, name);
			System.out.println("Executing query: "+ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					if (i > 1)
						System.out.print(",  ");
					String columnValue = rs.getString(i);
					System.out.print(columnValue + " " + rs.getMetaData().getColumnName(i));
				}
				System.out.println("");
				AuditTrail audittrail = new AuditTrail();
				audittrail.setId(rs.getInt("id"));
				audittrail.setConfig_id(rs.getInt("config_id"));
				audittrail.setName(rs.getString("name"));
				audittrail.setNewvalue(rs.getString("newvalue"));
				audittrail.setPreviousvalue(rs.getString("previousvalue"));
				audittrail.setDate(rs.getString("date"));

				audittrailList.add(audittrail);
			}
			return audittrailList;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
