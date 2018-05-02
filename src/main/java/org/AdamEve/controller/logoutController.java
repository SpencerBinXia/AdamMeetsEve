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
@RequestMapping("/logout")
public class logoutController {
	
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session)
	{
		session.setAttribute("currentUser", null);
		return "redirect:/";
	}
	
}