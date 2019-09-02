package com.crm.web.dao;

import java.util.List;

import com.crm.web.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomerList();

	public void addNewCustomer(Customer customer);
}
