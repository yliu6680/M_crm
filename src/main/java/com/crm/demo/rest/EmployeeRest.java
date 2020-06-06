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

import com.crm.demo.entity.Employee;
import com.crm.demo.service.AbstractBasicService;

@RestController
@RequestMapping("/api")
public class EmployeeRest {
	
	private AbstractBasicService<Employee> employeeService;
	
	@Autowired
	public EmployeeRest(AbstractBasicService<Employee> employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return this.employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		Employee theEmployee = this.employeeService.findById(employeeId);
		
		if (theEmployee == null) {
			System.out.println("employee id is not found - " + employeeId);
		}
		
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setEid(0);
		
		this.employeeService.saveObj(theEmployee);
		
		return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		this.employeeService.saveObj(theEmployee);
		
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee theEmployee = this.employeeService.findById(employeeId);
		
		if (theEmployee == null) {
			System.out.println("employee id is not found - " + employeeId);
		}
		
		this.employeeService.deleteById(employeeId);
		
		return "employee has been deleted with id - " + employeeId;
	}
}
