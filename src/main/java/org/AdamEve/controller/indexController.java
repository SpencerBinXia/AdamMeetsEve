package org.AdamEve.controller;

import org.AdamEve.object.loginInfo;
import org.AdamEve.object.registerInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class indexController {

	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model)
	{
		model.addAttribute("info", new loginInfo());
		return "register";
	}
}