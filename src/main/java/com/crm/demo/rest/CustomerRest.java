package com.crm.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.demo.entity.Customer;
import com.crm.demo.service.AbstractBasicService;

@RestController
@RequestMapping("/api")
public class CustomerRest {
	private AbstractBasicService<Customer> customerService;
	
	@Autowired
	public CustomerRest(AbstractBasicService<Customer> customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/customers")
	public List<Customer> findAllCustomers(){
		return this.customerService.findAll();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer findCustomer(@PathVariable int customerId){
		Customer theCustomer =  this.customerService.findById(customerId);
		
		if (theCustomer == null) {
			System.out.println("customer id not found - " + customerId);
		}
		
		return theCustomer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		theCustomer.setCid(0);
		
		this.customerService.saveObj(theCustomer);
		
		return theCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		this.customerService.saveObj(theCustomer);
		
		return theCustomer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer theCustomer = customerService.findById(customerId);
		
		// throw exception if null
		if (theCustomer == null) {
			System.out.println("customer id not found - " + customerId);
		}
		
		this.customerService.deleteById(customerId);
		
		return "Customer has been deleted with Id - " + customerId; 
	}
}
