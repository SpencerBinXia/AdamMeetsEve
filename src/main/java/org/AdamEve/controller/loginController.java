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
	public String login(@ModelAttribute("info") loginInfo info, HttpSession session)
	{
		System.out.println("logincontrol reached");
		boolean statusCode = service.loginUser(info, session);
		System.out.println("status code executed");
		return "redirect:/profile.html";
	}
}