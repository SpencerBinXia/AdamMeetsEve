package org.AdamEve.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
		System.out.println("sdfasdfasdf");
		return "index.html";
	}
}