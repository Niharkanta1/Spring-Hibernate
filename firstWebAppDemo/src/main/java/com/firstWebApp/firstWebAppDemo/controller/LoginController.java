package com.firstWebApp.firstWebAppDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.firstWebApp.firstWebAppDemo.model.Student;
import com.firstWebApp.firstWebAppDemo.services.LoginService;

@Controller
@SessionAttributes("userId")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model){		
		return "login";	
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomePage(@ModelAttribute("login")Student student, ModelMap model){	
		boolean isValidUser = loginService.validateUser(student.getUserId(), student.getPassword());
		if (!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }
		model.put("userId", student.getUserId());
		model.put("firstName", student.getFirstName());
        model.put("password", student.getPassword());
        return "welcome";	
	}
	
}
