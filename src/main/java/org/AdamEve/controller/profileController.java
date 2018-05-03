package org.AdamEve.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.AdamEve.object.*;
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
		model.addAttribute("foundProfile", foundProfile);
		searchInfo searchParameters = new searchInfo();
		model.addAttribute("searchParameters", searchParameters);
		List<likes> likedBy = userService.likedBy(profileID);
		List<likes> likedTo = userService.likedTo(profileID);
		List<date> dates = userService.getallDates(profileID);
		List<referral> referrals = userService.getreferralByID(profileID);
		model.addAttribute("likedBy", likedBy);
		model.addAttribute("likedTo", likedTo);
		model.addAttribute("allDates", dates);
		model.addAttribute("allReferrals", referrals);
		model.addAttribute("referinfo", new referInfo());
		System.out.println(foundProfile.getSsn() +"found");
		System.out.println(((user)session.getAttribute("currentUser")).getSsn() + "current");
		if ((foundProfile.getSsn()).equals(((user)session.getAttribute("currentUser")).getSsn())) {
			session.setAttribute("activeProfile", profileID);
			model.addAttribute("profinfo", new profileInfo());
			return "profile";
		}
		else {
			model.addAttribute("dateInfo", new dateInfo());
			String referTo = "";
			model.addAttribute("referinfo", new referInfo());
			return "otherProfile";
		}
	}
	
}
