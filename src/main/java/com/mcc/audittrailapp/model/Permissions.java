package com.mcc.audittrailapp.model;

import javax.persistence.Id;

public class Permissions {
	@Id
	private String configid;
	private String roleid;
	private String permissions;
	
	public String getConfigid() {
		return configid;
	}
	public void setConfigid(String configid) {
		this.configid = configid;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

}
