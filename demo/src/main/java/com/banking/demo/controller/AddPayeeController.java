package com.banking.demo.controller;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.demo.entity.Customer;
import com.banking.demo.entity.Payee;
import com.banking.demo.service.CustomerService;

@RestController
@RequestMapping("/add")
public class AddPayeeController {
	
	
	@Autowired
	CustomerService customerService;
	
	
}
