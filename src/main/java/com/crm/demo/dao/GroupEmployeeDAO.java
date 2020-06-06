package com.crm.demo.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.demo.entity.Employee;
import com.crm.demo.entity.Group;
import com.crm.demo.entity.GroupEmployee;

@Repository
public class GroupEmployeeDAO extends AbstractBasicDAO<GroupEmployee> {
	
	private EntityManager entityManager;
	
	@Autowired
	public GroupEmployeeDAO(EntityManager entityManager) {
		super(entityManager);
		this.entityManager = entityManager;
	}
	
	public void saveGroupEmployee(int theGroupId, int theEmployeeId, GroupEmployee theGroupEmployee) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Group theGroup = currentSession.get(Group.class, theGroupId);
		
		Employee theEmployee =currentSession.get(Employee.class, theEmployeeId);
		
		if (theGroup == null || theEmployee == null) {
			System.out.println("Group or employee not valid!!!");
		}
		
		theGroup.addGroupEmployees(theGroupEmployee);
		
		theEmployee.addGroupEmployees(theGroupEmployee);
		
		System.out.println("[INFO] --- Adding new employee, group relationship");
		
		System.out.println(theGroup);
		
		System.out.println(theEmployee);
		
		System.out.println(theGroupEmployee);
		
		currentSession.saveOrUpdate(theGroupEmployee);
		
	}
	
	public void updateGroupEmployee(int theGroupId, int theEmployeeId, GroupEmployee theGroupEmployee) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Group theGroup = currentSession.get(Group.class, theGroupId);
		
		Employee theEmployee =currentSession.get(Employee.class, theEmployeeId);
		
		if (theGroup == null || theEmployee == null) {
			System.out.println("Group or employee not valid!!!");
		}
		
		System.out.println("[INFO] --- Adding new employee, group relationship");
		
		theGroupEmployee.setEmployee(theEmployee);
		
		theGroupEmployee.setGroup(theGroup);
		
		System.out.println(theGroup);
		
		System.out.println(theEmployee);
		
		System.out.println(theGroupEmployee);
		
		currentSession.saveOrUpdate(theGroupEmployee);
	
	}
	
}
