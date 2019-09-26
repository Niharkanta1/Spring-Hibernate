package com.banking.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.demo.entity.Customer;
import com.banking.demo.entity.Payee;
import com.banking.demo.entity.TransactionDetail;

public interface CustomerService {	
	public Customer getCustomer(int id);

	public boolean addPayee(Payee payee);

	public boolean addPayee(Payee payee, int customer_id);

	public List getTransactionDetails(int id);
}
