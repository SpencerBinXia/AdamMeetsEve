package org.AdamEve.controller;

import javax.servlet.http.HttpSession;

import org.AdamEve.object.profile;
import org.AdamEve.object.profileInfo;
import org.AdamEve.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/viewuser/createProfile")
public class createProfileController {
	
	@Autowired
	private userService userService;
	
	@RequestMapping(method=RequestMethod.POST)
	public String createProfile(@ModelAttribute profileInfo ProfileInfo, HttpSession session, Model model)
	{
		userService.createProfile(ProfileInfo);

		session.setAttribute("activeProfile", ProfileInfo.getProfileID());
		return "redirect:/viewprofile/" + ProfileInfo.getProfileID();
	}
	
}