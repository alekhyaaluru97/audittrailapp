package com.mcc.audittrailapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Configuration { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String value;
	private String owner;
	private String manager;	
	private String roles;
	private String permissions;
	/*@ElementCollection
	@OneToMany(cascade = {CascadeType.PERSIST})
	private List<Role> roles;
	@ElementCollection
	private List<String> permissions;
	/*@ElementCollection
	private Map<String, String> changesMap;//holds what changes happened to the configuration 
	// key:configuration name, value: changes happened with time stamp*/
	
	public Configuration() {
		
	}
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Configuration [id=" + id + ", name=" + name + ", value=" + value + ", owner=" + owner + ", manager="
				+ manager + ", roles=" + roles + ", permissions=" + permissions + "]";
	}
}

