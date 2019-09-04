package com.crm.web.dao;

import java.util.List;

import com.crm.web.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomerList();

	public void addNewCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public Customer getCustomerById(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomerByName(String searchName);
}
