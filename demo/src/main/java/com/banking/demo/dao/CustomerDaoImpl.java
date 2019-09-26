package com.banking.demo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banking.demo.entity.Customer;
import com.banking.demo.entity.Payee;
import com.banking.demo.entity.TransactionDetail;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	int id=0;
	List<Customer> customerList = new ArrayList<Customer>();
	
	public CustomerDaoImpl() {
		customerList.add(new Customer(id++, "user", "password", new Date(), 1500.00));
		customerList.add(new Customer(id++, "nihar", "password", new Date(), 1600.00));
		customerList.add(new Customer(id++, "sachin", "cricket", new Date(), 1700.00));
		customerList.add(new Customer(id++, "admin", "admin", new Date(), 999.00));
		
	}
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public Customer getCustomer(int id) {
		/*
		for(Customer cust:customerList) {
			if(cust.getId() == id) {
				result = cust;
			}
		}	*/
		Session currentSession = entityManager.unwrap(Session.class);
		Customer result = currentSession.get(Customer.class, id);
		return result;
	}

	@Override
	@Transactional
	public boolean addPayee(Payee payee) {
		Session currentSession = entityManager.unwrap(Session.class);
		boolean result = true;
		try{
		currentSession.save(payee);
		}
		catch(Exception e){
			result = false;
		}
		return result;
	}

	@Override
	@Transactional
	public boolean addPayee(Payee payee, int customer_id) {
		boolean result = true;
		Session currentSession = entityManager.unwrap(Session.class);
		Customer cust = currentSession.get(Customer.class, customer_id);
		payee.setCustomer(cust);
		cust.addPayee(payee);
		currentSession.save(cust);
		currentSession.save(payee);
		return result;
	}

	@Override
	@Transactional
	public List<TransactionDetail> getTransactionDetails(int id) {
		Session session = entityManager.unwrap(Session.class);
		String hql = "FROM TransactionDetail TD WHERE TD.customerId = :id";		
		Query query = session.createQuery(hql);
		query.setParameter("id",id);
		List resultList = query.getResultList();
		return resultList;
	}

}
