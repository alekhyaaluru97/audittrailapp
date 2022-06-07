package com.mcc.audittrailapp.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mcc.audittrailapp.connection.GetConnection;
import com.mcc.audittrailapp.model.AuditTrail;
import com.mcc.audittrailapp.model.Configuration;

@Service
public class ConfigurationDAO {

	public boolean insertNewConfiguration(Configuration configuration) {
		try {
			String sql = "INSERT INTO configuration (id, name, value, owner, manager, roles, permissions) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ps.setInt(1, configuration.getId());
			ps.setString(2, configuration.getName());
			ps.setString(3, configuration.getValue());
			ps.setString(4, configuration.getOwner());
			ps.setString(5, configuration.getManager());
			ps.setString(6, configuration.getRoles());
			ps.setString(7, configuration.getPermissions());
			
			return ps.executeUpdate()>0;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateConfigurationValue(String configname, String value) {
		try {
			Configuration beforeUpdateConfiguration = getConfigurationByName(configname);
			String nameofConfigBeingUpdated = beforeUpdateConfiguration.getName();
			String valueBeforeUpdate = beforeUpdateConfiguration.getValue();
			
			AuditTrail audittrail = new AuditTrail();
			AuditTrailDAO audittraildao = new AuditTrailDAO();
			
			String sql = "UPDATE configuration set value=? WHERE name=?";
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ps.setString(1, value);
			ps.setString(2, configname);			
			boolean isConfigUpdated = ps.executeUpdate() > 0;
			if(isConfigUpdated) {				
				//audittrail.setConfig_id(configname);
				audittrail.setName(nameofConfigBeingUpdated);
				audittrail.setPreviousvalue(valueBeforeUpdate);
				audittrail.setNewvalue(value);
				
				boolean isAudittrailUpdated = audittraildao.addAuditTrail(audittrail);
				if(isAudittrailUpdated) {
					return true;
				}
			} else {
				return false;
			}			
			return isConfigUpdated;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteConfiguration(int id) {
		try {
			String sql = "DELETE FROM configuration WHERE id=?";
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			return ps.executeUpdate()>0;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Configuration getConfigurationByName(String name) {
		try {
			String sql = "SELECT * FROM configuration WHERE name=?";
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			        if (i > 1) System.out.print(",  ");
			        String columnValue = rs.getString(i);
			        System.out.print(columnValue + " " + rs.getMetaData().getColumnName(i));
			    }
			    System.out.println("");
				
				Configuration configuration = new Configuration();
				configuration.setId(rs.getInt("id"));
				configuration.setName(rs.getString("name"));
				configuration.setValue(rs.getString("value"));
				configuration.setOwner(rs.getString("owner"));
				configuration.setManager(rs.getString("manager"));
				configuration.setRoles(rs.getString("roles"));
				configuration.setPermissions(rs.getString("permissions"));
				return configuration;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Configuration> getAllConfigurations() {
		try {
			List<Configuration> configurationsList = new ArrayList<>();
			String sql = "SELECT * FROM configuration";
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			        if (i > 1) System.out.print(",  ");
			        String columnValue = rs.getString(i);
			        System.out.print(columnValue + " " + rs.getMetaData().getColumnName(i));
			    }
			    System.out.println("");
				Configuration configuration = new Configuration();
				configuration.setId(rs.getInt("id"));
				configuration.setName(rs.getString("name"));
				configuration.setValue(rs.getString("value"));
				configuration.setOwner(rs.getString("owner"));
				configuration.setManager(rs.getString("manager"));
				configuration.setRoles(rs.getString("roles"));
				configuration.setPermissions(rs.getString("permissions"));
				
				configurationsList.add(configuration);
			}
			return configurationsList;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
