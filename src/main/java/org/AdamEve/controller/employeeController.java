package org.AdamEve.controller;

import java.util.List;

import org.AdamEve.object.employee;
import org.AdamEve.object.employeeChangeInfo;
import org.AdamEve.object.profileInfo;
import org.AdamEve.object.searchInfo;
import org.AdamEve.object.user;
import org.AdamEve.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/viewemployee/{ssn}")
public class employeeController{
	
	@Autowired
	private userService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String displayProfile(@PathVariable("ssn") String employeeid, Model model)
	{
		employee foundEmployee = userService.findEmployee(employeeid);
		model.addAttribute("foundEmployee", foundEmployee);
		if (foundEmployee.getRole().equals("Manager")) {
			model.addAttribute("isManager", true);
			List<employee> allEmployees = userService.getEmployees();
			model.addAttribute("allEmployees", allEmployees);
		}
		else {
			model.addAttribute("isManager", false);
			model.addAttribute("allEmployees", null);
		}
		user foundEmployeePerson = userService.findUser(employeeid);
		model.addAttribute("foundEmployeePerson", foundEmployeePerson);
		searchInfo searchParameters = new searchInfo();
		model.addAttribute("searchParameters", searchParameters);
		employeeChangeInfo employeeinfo = new employeeChangeInfo();
		model.addAttribute("employeeChangeInfo", employeeinfo);
		return "employee";
	}
	
}