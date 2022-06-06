package com.mcc.audittrailapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcc.audittrailapp.model.Configuration;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Integer>{

}
