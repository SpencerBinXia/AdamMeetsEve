package org.AdamEve.controller;

import javax.servlet.http.HttpSession;

import org.AdamEve.object.registerInfo;
import org.AdamEve.service.loginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class registerController {
	
	@Autowired
	private loginRegisterService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String displayRegister(Model model) {
		model.addAttribute("reginfo", new registerInfo());
		return "register";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public boolean registerUser(@ModelAttribute registerInfo info, HttpSession session)
	{
		boolean statusCode = service.registerUser(info, session);
		return statusCode;
	}
	
}