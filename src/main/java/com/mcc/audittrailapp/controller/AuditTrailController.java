package com.mcc.audittrailapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcc.audittrailapp.model.AuditTrail;
import com.mcc.audittrailapp.model.Configuration;
import com.mcc.audittrailapp.service.AuditTrailDAO;

@RestController
@RequestMapping("/audittrail")
public class AuditTrailController {

	private AuditTrailDAO audittraildao = new AuditTrailDAO();

	@GetMapping("/getAll")
	public List<AuditTrail> getAllAuditTrail() {
		return audittraildao.getAllAuditTrail();
	}

	@GetMapping("/{name}")
	public List<AuditTrail> getAuditTrailByName(@RequestBody Configuration configuration) {
		return audittraildao.getAuditTrailByName(configuration.getName());
	}
}
