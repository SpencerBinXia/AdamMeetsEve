package org.AdamEve.controller;

import javax.servlet.http.HttpSession;

import org.AdamEve.object.employeeChangeInfo;
import org.AdamEve.object.registerInfo;
import org.AdamEve.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/changeemployeeinfo")
public class changeEmployeeInfoController{
	
	@Autowired
	private userService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public String changeInfoUser(@ModelAttribute employeeChangeInfo employeeinfo, HttpSession session)
	{
		service.changeEmployeeInfo(employeeinfo, session);
		return "user";
	}
	
}