package com.crm.demo.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.demo.entity.Group;

 @Repository
public class GroupDAO extends AbstractBasicDAO<Group> {
	
	private EntityManager entityManager;
	
	@Autowired
	public GroupDAO(EntityManager entityManager) {
		super(entityManager);
		this.entityManager = entityManager;
	}
	
}
