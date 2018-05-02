package org.AdamEve.controller;

import org.AdamEve.object.profile;
import org.AdamEve.object.searchInfo;
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
	public String displayProfile(@PathVariable("profileID") String profileID, Model model)
	{
		profile foundProfile = userService.findProfile(profileID);
		model.addAttribute("foundProfile", foundProfile);
		searchInfo searchParameters = new searchInfo();
		model.addAttribute("searchParameters", searchParameters);
		return "profile";
	}
	
}