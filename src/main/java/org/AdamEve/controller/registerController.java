package org.AdamEve.controller;

import javax.servlet.http.HttpSession;

import org.AdamEve.object.loginInfo;
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
		model.addAttribute("info", new loginInfo());
		model.addAttribute("reginfo", new registerInfo());
		return "register";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String registerUser(@ModelAttribute registerInfo reginfo, HttpSession session)
	{
		service.registerUser(reginfo, session);
		System.out.println(reginfo.getFirstName());
		return "redirect:/viewuser/" + reginfo.getSsn();
	}
	
}