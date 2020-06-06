package com.crm.demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.crm.demo.dao.AbstractBasicDAO;

public abstract class AbstractBasicService<T> implements IBasicService<T> {
	
	AbstractBasicDAO<T> dao;
	
	public AbstractBasicService(AbstractBasicDAO<T> dao) {
		this.dao = dao;
	}
	
	@Override
	@Transactional
	public List<T> findAll() {
		return this.dao.findAll();
	}
	
	@Override
	@Transactional
	public T findById(int theId) {
		return this.dao.findById(theId);
	}
	
	@Override
	@Transactional
	public void saveObj(T obj) {
		this.dao.saveObj(obj);
	}
	
	@Override
	@Transactional
	public void deleteById(int theId) {
		this.dao.deleteById(theId);
	}
}
