package com.banking.demo.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.interceptor.TransactionAttributeSourceAdvisor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.demo.entity.Customer;
import com.banking.demo.entity.Payee;
import com.banking.demo.entity.TransactionDetail;
import com.banking.demo.model.CustomerResponseObj;
import com.banking.demo.model.TransactionStatementObj;
import com.banking.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class DashboardRestController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping(path="/home/{id}", produces = "application/json")
	public CustomerResponseObj getDashboard(@PathVariable int id) {
		CustomerResponseObj result = new CustomerResponseObj();
		Customer cust = customerService.getCustomer(id);
		
		result.setName(cust.getName());
		result.setLastLogin(cust.getLastLogin());
		result.setBalance(cust.getBalance());
		
		return result;
	}
	
	@PostMapping(path="/addpayee/{customer_id}", produces = "application/json")
	public ResponseEntity addPayee(@RequestBody Payee payee, @PathVariable int customer_id) {
		
		boolean status = customerService.addPayee(payee, customer_id);
		if(status == true)
			return new ResponseEntity(HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@GetMapping(path="/statement/{id}", produces = "application/json")
	public List<TransactionStatementObj> getBankStatement(@PathVariable int id) {
		List<TransactionStatementObj> result = new ArrayList<TransactionStatementObj>();
		List<TransactionDetail> list = customerService.getTransactionDetails(id);
		
		for (TransactionDetail tnx : list) {
			result.add(new TransactionStatementObj(tnx.getId(), tnx.getDate(), tnx.getType(), tnx.getCustomerId(), tnx.getAmount()));
		}
		
		return result;
	}
}
