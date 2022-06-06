package com.mcc.audittrailapp.service;

import java.util.List;

import com.mcc.audittrailapp.model.Configuration;

public interface ConfigurationService {
	
	public Configuration saveConfiguration(Configuration configuration);
	
	public List<Configuration> getAllConfigurations();
	
	public void save(Configuration configuration);
	
	public void delete(Integer id);
	
	public Configuration get(Integer id);
}
