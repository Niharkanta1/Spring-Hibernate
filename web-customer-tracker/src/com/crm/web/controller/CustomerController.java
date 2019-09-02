package com.crm.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crm.web.dao.CustomerDAOImpl;
import com.crm.web.entity.Customer;
import com.crm.web.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private static Logger logger = Logger.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/list-customers")
	public String getCustomerList(Model model){
		List<Customer> customers = customerService.getCustomerList();
		model.addAttribute("customers", customers);
		return "list-customers";
	}
	
	@GetMapping("/add-customer")
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add-customer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveNewCustomer(customer);
		return "redirect:list-customers";
	}
}
