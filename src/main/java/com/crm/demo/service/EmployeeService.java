package com.crm.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.demo.dao.EmployeeDAO;
import com.crm.demo.entity.Employee;

@Service
public class EmployeeService extends AbstractBasicService<Employee> {
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeService(EmployeeDAO employeeDAO) {
		super(employeeDAO);
		this.employeeDAO = employeeDAO;
	}
	
}
