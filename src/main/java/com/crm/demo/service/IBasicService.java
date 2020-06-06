package com.crm.demo.service;

import java.util.List;

public interface IBasicService<T> {
	public List<T> findAll();
	
	public T findById(int theId);
	
	public void saveObj(T obj);
	
	public void deleteById(int theId);
	
}
