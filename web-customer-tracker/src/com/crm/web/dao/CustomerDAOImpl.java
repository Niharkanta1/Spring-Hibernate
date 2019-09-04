package com.crm.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.web.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
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
		factory.getCurrentSession().save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		factory.getCurrentSession().saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer = factory.getCurrentSession().get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		Query query = factory.getCurrentSession().createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);		
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomerByName(String searchName) {
		Query<Customer> query = null;
		if (searchName != null && searchName.trim().length() > 0) {
			query = factory.getCurrentSession().createQuery("from Customer where lower(firstName) like:theName or lower(lastName) like:theName ");
			query.setParameter("theName", "%"+searchName+"%");
		}
		else {
			// theSearchName is empty ... so just get all customers
           query =factory.getCurrentSession().createQuery("from Customer", Customer.class); 
		}
		List<Customer> customerList  = query.getResultList();
		
		return customerList;	
	}

}
