package org.AdamEve.controller;

import org.AdamEve.object.*;
import org.AdamEve.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/viewuser/{ssn}")
public class userController {
	
	@Autowired
	private userService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String displayProfile(@PathVariable("ssn") String userid, HttpSession session, Model model)
	{
		if (((user)session.getAttribute("currentUser")).getSsn().equals(userid)) {
			user foundUser = userService.findUser(userid);
			model.addAttribute("foundUser", foundUser);
			searchInfo searchParameters = new searchInfo();
			model.addAttribute("searchParameters", searchParameters);
			profileInfo createProfile = new profileInfo();
			model.addAttribute("ProfileInfo", createProfile);
			List<profile> profileList = userService.finduserProfiles(userid);
			model.addAttribute("userProfiles", profileList);
			model.addAttribute("reginfo", new registerInfo());
			return "user";
		}
		else {
			return "redirect:/viewuser/" + ((user)session.getAttribute("currentUser")).getSsn();
		}
	}
	
}