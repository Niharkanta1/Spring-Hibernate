package com.crm.web.service;

import java.util.List;
import com.crm.web.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomerList();

	public void saveNewCustomer(Customer customer);
}
