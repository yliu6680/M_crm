package com.crm.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.demo.dao.GroupEmployeeDAO;
import com.crm.demo.entity.GroupEmployee;

@Service
public class GroupEmployeeService extends AbstractBasicService<GroupEmployee> {
	
	private GroupEmployeeDAO groupEmployeeDAO;
	
	@Autowired
	public GroupEmployeeService(GroupEmployeeDAO groupEmployeeDAO) {
		super(groupEmployeeDAO);
		this.groupEmployeeDAO = groupEmployeeDAO;
	}
	
	@Transactional
	public void saveGroupEmployee(int theGroupId, int theEmployeeId, GroupEmployee theGroupEmployee) {
		this.groupEmployeeDAO.saveGroupEmployee(theGroupId, theEmployeeId, theGroupEmployee);
	}
	
	@Transactional
	public void updateGroupEmployee(int theGroupId, int theEmployeeId, GroupEmployee theGroupEmployee) {
		this.groupEmployeeDAO.updateGroupEmployee(theGroupId, theEmployeeId, theGroupEmployee);
	}
}
