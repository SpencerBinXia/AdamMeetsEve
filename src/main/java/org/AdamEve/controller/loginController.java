package org.AdamEve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.AdamEve.object.loginInfo;
import org.AdamEve.service.loginRegisterService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path="/login")
public class loginController {
	
	@Autowired
	private loginRegisterService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(@ModelAttribute loginInfo info, HttpSession session)
	{
		boolean statusCode = service.loginUser(info, session);
		return "profile";
	}
}