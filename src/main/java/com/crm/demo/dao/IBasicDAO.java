package com.crm.demo.dao;

import java.util.List;

public interface IBasicDAO<T> {
	public List<T> findAll();
	
	public T findById(int theId);
	
	public void saveObj(T obj);
	
	public void deleteById(int theId);
	
}
