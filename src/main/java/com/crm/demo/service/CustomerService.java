package com.crm.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.demo.dao.CustomerDAO;
import com.crm.demo.entity.Customer;

@Service
public class CustomerService extends AbstractBasicService<Customer> {
	
	private CustomerDAO customerDAO;
	
	@Autowired
	public CustomerService(CustomerDAO customerDAO) {
		super(customerDAO);
		this.customerDAO = customerDAO;
	}

}
