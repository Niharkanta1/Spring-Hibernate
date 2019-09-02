package com.crm.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.web.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	private static Logger logger = Logger.getLogger(CustomerDAOImpl.class);
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public List<Customer> getCustomerList() {
		
		List<Customer> customerList = new ArrayList<Customer>();
		customerList = factory.getCurrentSession().createQuery("from Customer order by firstName").getResultList();
		return customerList;
	}

	@Override
	public void addNewCustomer(Customer customer) {
		logger.info("Saving the customer :"+customer);
		
		factory.getCurrentSession().save(customer);
		
		logger.info("Customer saved into database.");
	}

}
