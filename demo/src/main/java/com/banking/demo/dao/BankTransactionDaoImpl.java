package com.banking.demo.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banking.demo.entity.TransactionDetail;

@Repository
public class BankTransactionDaoImpl implements BankTransactionDao {
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	@Transactional
	public TransactionDetail transferFund(TransactionDetail details) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(details);
		return details;
	}

}
