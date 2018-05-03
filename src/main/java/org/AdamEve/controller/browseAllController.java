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
@RequestMapping("/displayall")
public class browseAllController {
	
	@Autowired
	private userService service;
	
	@GetMapping
	public String getAllProfiles(Model model)
	{
		List<profile> allProfiles = service.getAllProfiles();
		model.addAttribute("allProfiles", allProfiles);
		return "displayall";
	}
	
}