package com.crm.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.demo.entity.Customer;
import com.crm.demo.entity.Employee;
import com.crm.demo.service.TestService;

@RestController
@RequestMapping("/test-api")
public class TestRest {
	
	private TestService testService;
	
	@Autowired
	public TestRest(TestService testService) {
		this.testService = testService;
	}
	
	@GetMapping("/hello")
	public String sayHi() {
		return "hello";
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCusomters(){
		return testService.findAllCustomers();
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return testService.findAllEmployees();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId){
		return testService.findEmployeeById(employeeId);
	}
	
	@GetMapping("/groupmembers")
	public List<Employee> getMembers(){
		List<Employee> results = testService.findAllMembersByGroupId(1);
		System.out.println("in the controller: " + results.getClass());
		return null;
	}
}
