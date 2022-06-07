package com.mcc.audittrailapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {
	@RequestMapping("/")
	public String showMainPage() {
		//ModelAndView modelAndView = new ModelAndView("index");
		return "index";
	}
	
	@RequestMapping("/index")
	public String showMainPageIcon() {
		//ModelAndView modelAndView = new ModelAndView("index");
		return "index";
	}
	
	@RequestMapping("/editconfigurations")
	ModelAndView showEditConfigurationsPage() {
		ModelAndView modelAndView = new ModelAndView("editconfigurations");
		return modelAndView;
	}
	
	@RequestMapping("/viewaudittrailbyname")
	ModelAndView showViewAudittrailByName() {
		ModelAndView modelAndView = new ModelAndView("viewaudittrailbyname");
		return modelAndView;
	}

}
