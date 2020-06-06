package com.crm.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.demo.entity.Customer;
import com.crm.demo.entity.Employee;
import com.crm.demo.entity.GroupEmployee;

@Repository
public class TestDao {
	private EntityManager entityManager;

	@Autowired
	public TestDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public List<Customer> findAllCustomers() {

		// get current session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);

		// execute query and get result list
		List<Customer> customers = query.getResultList();

		// return the results
		return customers;
	}

	@Transactional
	public List<Employee> findAllMembersByGroupId(int theId) {

		// get current session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<GroupEmployee> query = currentSession.createQuery("from GroupEmployee where gid = :theGroupId",
				GroupEmployee.class);

		query.setParameter("theGroupId", theId);
		// execute query and get result list
		List<GroupEmployee> ids = query.getResultList();

		System.out.println(ids.size());

		List<Employee> employees = new ArrayList<Employee>();

		for (GroupEmployee item : ids) {
			employees.add(item.getEmployee());
		}

		System.out.println(employees);
		return employees;
	}

	@Transactional
	public List<Employee> findAllEmployees() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

		// execute query and get result list
		List<Employee> employees = query.getResultList();

		// return the results
		return employees;
	}
	
	@Transactional
	public Employee findEmployeeById(int employeeId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee theEmployee = currentSession.get(Employee.class, employeeId);
		
		return theEmployee;
	}
}
