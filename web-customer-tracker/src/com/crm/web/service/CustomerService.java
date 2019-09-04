package com.crm.web.service;

import java.util.List;
import com.crm.web.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomerList();

	public void saveNewCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public Customer getCustomerById(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomerByName(String searchName);
}
