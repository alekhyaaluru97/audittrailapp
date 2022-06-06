package com.mcc.audittrailapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcc.audittrailapp.model.Configuration;
import com.mcc.audittrailapp.repository.ConfigurationRepository;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

	@Autowired
	private ConfigurationRepository configurationRepository;

	@Override
	public Configuration saveConfiguration(Configuration configuration) {
		return configurationRepository.save(configuration);
	}

	@Override
	public List<Configuration> getAllConfigurations() {
		return configurationRepository.findAll();
	}

	@Override
	public void save(Configuration configuration) {
		configurationRepository.save(configuration);
	}
	
	@Override
	public Configuration get(Integer id) {
		return configurationRepository.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		configurationRepository.deleteById(id);
	}

}
