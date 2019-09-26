package com.banking.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.banking.demo.entity.Customer;
import com.banking.demo.entity.Payee;
import com.banking.demo.service.CustomerService;

@Controller
public class DashboardController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping(path="/home/{id}")
	public String getDashboard(Model model, @RequestParam int id) {
		Customer result = customerService.getCustomer(id);
		model.addAttribute("customer", result);
		return "dashboard";
	}
	
	@PostMapping(path="/addpayee")
	public String addPayee(@RequestParam Payee payee) {
		
		boolean status = customerService.addPayee(payee);
		if(status == true)
			return "dashboard";
		else
			return "error";
	}
	
}
