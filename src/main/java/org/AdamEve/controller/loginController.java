package org.AdamEve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.AdamEve.object.loginInfo;
import org.AdamEve.object.user;
import org.AdamEve.service.loginRegisterService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class loginController {
	
	@Autowired
	private loginRegisterService service;
	
	@PostMapping
	public String login(@ModelAttribute loginInfo info, HttpSession session, Model model)
	{
		if (service.loginUser(info, session) == true) {
			model.addAttribute("failedlogin", false);
			user tempuser = (user)session.getAttribute("currentUser");
			return "redirect/user/" + tempuser.getSsn();
		}
		else {
			model.addAttribute("failedlogin", true);
			model.addAttribute("info", new loginInfo());
			return "index";
		}
	}
	
}