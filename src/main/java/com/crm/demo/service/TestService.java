package com.crm.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.demo.dao.TestDao;
import com.crm.demo.entity.Customer;
import com.crm.demo.entity.Employee;

@Service
public class TestService {
	private TestDao testDao;
	
	@Autowired
	public TestService(TestDao testDao) {
		this.testDao = testDao;
	}
	
	public List<Customer> findAllCustomers(){
		return this.testDao.findAllCustomers();
	}
	
	public List<Employee> findAllMembersByGroupId(int theId){
		return this.testDao.findAllMembersByGroupId(theId);
	}

	public List<Employee> findAllEmployees(){
		return this.testDao.findAllEmployees();
	}

	public Employee findEmployeeById(int employeeId) {
		return this.testDao.findEmployeeById(employeeId);
	}
}	

