package com.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class WelcomeController {
	
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String showWelcome(Model model) {
	      return "welcome";
	}
}
