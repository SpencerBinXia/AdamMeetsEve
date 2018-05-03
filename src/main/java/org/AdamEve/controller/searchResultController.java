package org.AdamEve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.AdamEve.object.profile;
import org.AdamEve.object.searchInfo;
import org.AdamEve.object.user;
import org.AdamEve.service.userService;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/searchresult")
public class searchResultController {
	
	@Autowired
	private userService service;
	
	@PostMapping
	public String search(@ModelAttribute searchInfo info, Model model)
	{
		List<profile> searchResults = service.searchProfiles(info);
		model.addAttribute("searchResults", searchResults);
		searchInfo searchParameters = new searchInfo();
		model.addAttribute("searchParameters", searchParameters);
		return "searchresult";
	}
	
}