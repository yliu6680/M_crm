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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crm.demo.entity.GroupEmployee;
import com.crm.demo.service.EmployeeService;
import com.crm.demo.service.GroupEmployeeService;
import com.crm.demo.service.GroupService;

@RestController
@RequestMapping("api")
public class GroupEmployeeRest {
	
	private GroupEmployeeService groupEmployeeService;
	
	private GroupService groupService;
	
	private EmployeeService employeeService;
	
	@Autowired
	public GroupEmployeeRest(GroupEmployeeService groupEmployeeService,
							 GroupService groupService,
							 EmployeeService employeeService) {
		this.groupEmployeeService = groupEmployeeService;
		this.groupService = groupService;
		this.employeeService = employeeService;
	}
	
	@GetMapping("/groupemployees")
	public List<GroupEmployee> findAll(){
		return this.groupEmployeeService.findAll();
	}
	
	@GetMapping("/groupemployees/{groupEmployeeId}")
	public GroupEmployee findGroupEmployeeById(@PathVariable int groupEmployeeId){
		GroupEmployee theGroupEmployee = this.groupEmployeeService.findById(groupEmployeeId);
		
		if (theGroupEmployee == null) {
			System.out.println("GroupEmployee id not found - " + groupEmployeeId);
		}
		
		return theGroupEmployee;
	}
	
	@PostMapping("/groupemployees")
	public GroupEmployee addGroupEmployee(@RequestParam("gid") int theGroupId,
										  @RequestParam("eid") int theEmployeeId,
										  @RequestBody GroupEmployee theGroupEmployee) {
		theGroupEmployee.setGeid(0);
		
		this.groupEmployeeService.saveGroupEmployee(theGroupId, theEmployeeId, theGroupEmployee);
		
		return theGroupEmployee;
	}
	
	@PutMapping("/groupemployees")
	public GroupEmployee updateGroupEmployee(@RequestParam("gid") int theGroupId,
											 @RequestParam("eid") int theEmployeeId,
											 @RequestBody GroupEmployee theGroupEmployee) {
		this.groupEmployeeService.updateGroupEmployee(theGroupId, theEmployeeId, theGroupEmployee);
		
		return theGroupEmployee;
	}
	
	@DeleteMapping("/groupemployees/{groupEmployeeId}")
	public String deleteGroupEmployee(@PathVariable int groupEmployeeId) {
		GroupEmployee theGroupEmployee= this.groupEmployeeService.findById(groupEmployeeId);
		
		if (theGroupEmployee == null) {
			System.out.println("Group employee relationship not found with id - " + groupEmployeeId);
		}
		
		this.groupEmployeeService.deleteById(groupEmployeeId);
		
		return "Group employee relationship has been deleted with id - " + groupEmployeeId;
	}
	
}
