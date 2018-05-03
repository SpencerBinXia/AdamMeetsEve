package org.AdamEve.controller;

import javax.servlet.http.HttpSession;

import org.AdamEve.object.profile;
import org.AdamEve.object.searchInfo;
import org.AdamEve.object.user;
import org.AdamEve.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/viewprofile/{profileID}")
public class profileController {
	
	@Autowired
	private userService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String displayProfile(@PathVariable("profileID") String profileID,HttpSession session, Model model)
	{
		profile foundProfile = userService.findProfile(profileID);
		if ((foundProfile.getSsn()).equals(((user)session.getAttribute("currentUser")).getSsn())) {
			model.addAttribute("foundProfile", foundProfile);
			searchInfo searchParameters = new searchInfo();
			model.addAttribute("searchParameters", searchParameters);
			return "profile";
		}
		else {
			return "redirect:/viewuser/" + ((user)session.getAttribute("currentUser")).getSsn();
		}
	}
	
}
