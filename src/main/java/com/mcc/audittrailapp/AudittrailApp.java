package com.mcc.audittrailapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.mcc.audittrailapp.controller"})
public class AudittrailApp {

	public static void main(String[] args) {
		SpringApplication.run(AudittrailApp.class, args);
	}
}
