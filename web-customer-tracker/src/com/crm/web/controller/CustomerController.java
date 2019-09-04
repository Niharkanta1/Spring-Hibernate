package com.crm.web.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/add-customer{editFlag}")
	public String addCustomer(Model model, @RequestParam("editFlag") boolean editFlag) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		model.addAttribute("editFlag", editFlag);
		return "addEdit-customer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer, @RequestParam("editFlag") boolean editFlag) {
		if(editFlag)
			customerService.updateCustomer(customer);
		else
			customerService.saveNewCustomer(customer);
		return "redirect:list-customers";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam Map<String, String> params, Model model) {
		Customer customer = customerService.getCustomerById(Integer.parseInt(params.get("customerId")));
		model.addAttribute("customer", customer);
		model.addAttribute("editFlag", params.get("editFlag"));
		return "addEdit-customer";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomer(id);
		return "redirect:list-customers";
	}
	
	@GetMapping("/searchCustomer")
	public String searchCustomer(@RequestParam("searchName") String searchName, Model model) {
		List<Customer> customers = customerService.searchCustomerByName(searchName);
		model.addAttribute("customers", customers);
		model.addAttribute("searchName", searchName);
		return "list-customers";
	}
}
