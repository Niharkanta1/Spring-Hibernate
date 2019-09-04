package com.crm.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.web.dao.CustomerDAO;
import com.crm.web.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomerList() {
		return customerDAO.getCustomerList();
	}

	@Override
	@Transactional
	public void saveNewCustomer(Customer customer) {
		
		customerDAO.addNewCustomer(customer);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		
		customerDAO.updateCustomer(customer);
		
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		
		return customerDAO.getCustomerById(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
		
	}

	@Override
	@Transactional
	public List<Customer> searchCustomerByName(String searchName) {
		return customerDAO.searchCustomerByName(searchName);
		
	}

}
