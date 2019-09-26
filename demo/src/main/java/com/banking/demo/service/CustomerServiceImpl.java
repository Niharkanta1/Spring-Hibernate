package com.banking.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.demo.dao.CustomerDao;
import com.banking.demo.entity.Customer;
import com.banking.demo.entity.Payee;
import com.banking.demo.entity.TransactionDetail;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}

	@Override
	public boolean addPayee(Payee payee) {
		
		return customerDao.addPayee(payee);
	}

	@Override
	public boolean addPayee(Payee payee, int customer_id) {
	
		return customerDao.addPayee(payee, customer_id);
	}

	@Override
	public List getTransactionDetails(int id) {
		
		return customerDao.getTransactionDetails(id);
	}

}
