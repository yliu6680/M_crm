package com.crm.demo.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.demo.entity.Customer;

@Repository
public class CustomerDAO extends AbstractBasicDAO<Customer> {

	private EntityManager entityManager;
	
	@Autowired
	public CustomerDAO(EntityManager entityManager) {
		super(entityManager);
		this.entityManager = entityManager;
	}
	
}
