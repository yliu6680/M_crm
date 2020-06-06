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

import com.crm.demo.entity.Group;
import com.crm.demo.service.AbstractBasicService;

@RestController
@RequestMapping("/api")
public class GroupRest {
	
	private AbstractBasicService<Group> groupService;
	
	@Autowired
	public GroupRest(AbstractBasicService<Group> groupService) {
		this.groupService = groupService;
	}
	
	@GetMapping("/groups")
	public List<Group> findAllCustomers(){
		return this.groupService.findAll();
	}
	
	@GetMapping("/groups/{groupId}")
	public Group findCustomer(@PathVariable int groupId){
		Group theGroup =  this.groupService.findById(groupId);
		
		if (theGroup == null) {
			System.out.println("customer id not found - " + groupId);
		}
		
		return theGroup;
	}
	
	@PostMapping("/groups")
	public Group addGroup(@RequestBody Group theGroup) {
		theGroup.setGid(0);
		
		this.groupService.saveObj(theGroup);
		
		return theGroup;
	}
	
	@PutMapping("/groups")
	public Group updateGroup(@RequestBody Group theGroup) {
		this.groupService.saveObj(theGroup);
		
		return theGroup;
	}
	
	@DeleteMapping("/groups/{groupId}")
	public String deleteGroup(@PathVariable int groupId) {
		Group theGroup =  this.groupService.findById(groupId);
		
		if (theGroup == null) {
			System.out.println("customer id not found - " + groupId);
		}
		
		this.groupService.deleteById(groupId);
		
		return "Group has been deleted with id - " + groupId;
	}
}
