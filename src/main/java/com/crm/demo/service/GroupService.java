package com.crm.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.demo.dao.GroupDAO;
import com.crm.demo.entity.Group;

@Service
public class GroupService extends AbstractBasicService<Group> {
	
	private GroupDAO groupDAO;
	
	@Autowired
	public GroupService(GroupDAO groupDAO) {
		super(groupDAO);
		this.groupDAO = groupDAO;
	}
	
}
