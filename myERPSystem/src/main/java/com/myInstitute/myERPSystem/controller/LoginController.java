package com.myInstitute.myERPSystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.myInstitute.myERPSystem.model.Student;
import com.myInstitute.myERPSystem.services.LoginService;


@Controller
@SessionAttributes("userId")
public class LoginController {
	@Autowired
	LoginService loginService;
	private static final Logger logger = LogManager.getLogger(LoginController.class);
	HttpSession session = null;
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model){
		logger.debug("Redirecting to Login Page.");
		return "login";	
	}
	
	@RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
	public String homePage(ModelMap model){
		logger.debug("Redirecting to Home Page.");
		return "home";	
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomePage(@ModelAttribute("login")Student student, ModelMap model, HttpServletRequest request){	
		logger.debug("Initializing the Login Process.");
		boolean isValidUser = loginService.validateUser(student);
		if (!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");
            logger.debug("Invalid credentials entered.");
            return "login";
        }
		model.put("userId", student.getUserId());
		model.put("firstName", student.getFirstName());
        model.put("password", student.getPassword());
        logger.debug("Login Successful. Redirecting to welcome screen.");
        return "home";	
	}
	@RequestMapping(value="/logoff", method = RequestMethod.GET)
	public String logOff(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		if(null!=request.getSession()){
			request.getSession().invalidate();
		}
		model.remove("userId");
		logger.debug("Loging Off.");
		return "home";	
	}
	
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public String aboutUs(ModelMap model){
		logger.debug("Redirecting to About Page.");
		return "about";	
	}
	
}
