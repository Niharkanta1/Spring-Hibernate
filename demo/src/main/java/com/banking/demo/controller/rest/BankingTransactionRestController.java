package com.banking.demo.controller.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.demo.entity.TransactionDetail;
import com.banking.demo.service.BankTransactionService;

@RestController
@RequestMapping("/tx/transaction")
public class BankingTransactionRestController {
	
	@Autowired
	BankTransactionService bankTransactionService;

	@PostMapping(path="/transfer/{fromAccountId}")
	public ResponseEntity transferFund(@RequestBody TransactionDetail transaction, @PathVariable int fromAccountId){		
		transaction.setDate(new Date());
		TransactionDetail result = bankTransactionService.transfer(transaction);
		return ResponseEntity.ok(result);
	}
}
