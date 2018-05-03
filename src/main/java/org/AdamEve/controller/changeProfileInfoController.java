package org.AdamEve.controller;

import org.AdamEve.object.profile;
import org.AdamEve.object.profileInfo;
import org.AdamEve.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/changeprofinfo")
public class changeProfileInfoController {
	
	@Autowired
	private userService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public String changeInfo(@ModelAttribute profileInfo profinfo, HttpSession session)
	{
		service.changeProfInfo(profinfo, session);
		return "redirect:/viewprofile/" + profinfo.getProfileID();
	}

	
}