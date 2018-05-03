package org.AdamEve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.AdamEve.object.loginInfo;
import org.AdamEve.object.registerInfo;
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
			user tempuser = (user)session.getAttribute("currentUser");
			if (service.isEmployee(tempuser.getSsn())) {
				return "redirect:/viewemployee/" + tempuser.getSsn();
			}
			return "redirect:/viewuser/" + tempuser.getSsn();
		}
		else {;
			return "redirect:/";
		}
	}
	
}