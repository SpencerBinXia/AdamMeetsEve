package org.AdamEve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.AdamEve.object.loginInfo;
import org.AdamEve.service.loginRegisterService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class loginController {
	
	@Autowired
	private loginRegisterService service;
	
	@PostMapping
	public String login(@ModelAttribute loginInfo info, HttpSession session)
	{
		if (service.loginUser(info, session) == true) {
			return "profile";
		}
		else {
			return "index";
		}
	}
	
}