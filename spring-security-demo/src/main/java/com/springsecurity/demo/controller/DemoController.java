package com.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	@GetMapping("/leader")
	public String showManagerScreen() {
		return "home-leader";
	}
	@GetMapping("/system")
	public String showAdminScreen() {
		return "home-admin";
	}
}
