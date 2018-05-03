package org.AdamEve.controller;

import javax.servlet.http.HttpSession;

import org.AdamEve.object.profile;
import org.AdamEve.object.profileInfo;
import org.AdamEve.object.user;
import org.AdamEve.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/viewprofile/{profileID}/addLike")
public class addLikeController {
	
	@Autowired
	private userService userService;
	
	@RequestMapping(method=RequestMethod.POST)
	public String createProfile(@PathVariable("profileID") String profileID,HttpSession session, Model model)
	{
		userService.addLike(profileID, (String)session.getAttribute("activeProfile"));
		return "redirect:/viewprofile/" + profileID;
	}
	
}