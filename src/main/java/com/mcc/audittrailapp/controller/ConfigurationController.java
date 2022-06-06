package com.mcc.audittrailapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcc.audittrailapp.model.Configuration;
import com.mcc.audittrailapp.service.ConfigurationDAO;

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {
	
	private ConfigurationDAO configurationdao = new ConfigurationDAO();
	
	@PostMapping("/add")
	public boolean add(@RequestBody Configuration configuration) {
		System.out.println("configuration json:"+configuration.toString());
		configuration.toString();//log
		boolean state = configurationdao.insertNewConfiguration(configuration);
		return state;
	}
	
	@GetMapping("/getAll")
	public List<Configuration> getAllConfigurations() {
		return configurationdao.getAllConfigurations();
	}
	
	@GetMapping("/{id}")
    public Configuration getConfigurationById(@PathVariable Integer id) {
        return configurationdao.getConfigurationById(id);            
    }

    @PutMapping("/{id}")
    public boolean update(@RequestBody Configuration configuration){
        return configurationdao.updateConfigurationValue(configuration.getId(), configuration.getValue());
    }
    
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
    	return configurationdao.deleteConfiguration(id);
    }


}
