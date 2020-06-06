package com.crm.demo.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.demo.entity.Employee;

@Repository
public class EmployeeDAO extends AbstractBasicDAO<Employee> {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAO(EntityManager entityManager) {
		super(entityManager);
		this.entityManager = entityManager;
	}

}
