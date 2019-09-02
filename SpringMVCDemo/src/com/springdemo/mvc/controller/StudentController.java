package com.springdemo.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.mvc.bean.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryList}") 
	private Map<String, String> countryOptions;
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		theModel.addAttribute("countryOptions", countryOptions);
		
		List<String> OSList = new ArrayList<String>();
		OSList.add("Microsoft Windows");
		OSList.add("Mac OS");
		OSList.add("Linux");
		OSList.add("Kali Unix");
		theModel.addAttribute("OSList", OSList);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
				
		return "student-confirmation";
	}
	
}
