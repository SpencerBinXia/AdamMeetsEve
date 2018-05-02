package org.AdamEve.controller;

import javax.servlet.http.HttpSession;

import org.AdamEve.object.registerInfo;
import org.AdamEve.service.loginRegisterService;
import org.AdamEve.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/changeinfo")
public class changeInfoController{
	
	@Autowired
	private userService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public String registerUser(@ModelAttribute registerInfo reginfo, HttpSession session)
	{
		service.changeUserInfo(reginfo, session);
		return "user";
	}
	
	/*@RequestMapping(method=RequestMethod.POST)
	public String registerUser(@ModelAttribute profileInfo reginfo, HttpSession session)
	{
		service.changeUserInfo(reginfo, session);
		return "user";
	}*/
	
	
}