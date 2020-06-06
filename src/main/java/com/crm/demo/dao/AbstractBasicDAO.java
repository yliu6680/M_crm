package com.crm.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.core.GenericTypeResolver;

public abstract class AbstractBasicDAO<T> implements IBasicDAO<T> {

	private EntityManager entityManager;

	private final Class<T> genericType;

	public AbstractBasicDAO(EntityManager entityManager) {
		this.entityManager = entityManager;

		// resolve the generic type
		this.genericType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractBasicDAO.class);

	}

	@Override
	public List<T> findAll() {
		// get current session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		String hql = String.format("from %s", genericType.getName());
		
		Query<T> query = currentSession.createQuery(hql, genericType);

		// execute query and get result list
		List<T> objects = query.getResultList();

		// return the results
		return objects;
	}

	@Override
	public T findById(int theId) {
		// get current session
		Session currentSession = entityManager.unwrap(Session.class);
		
		System.out.println(genericType);
		System.out.println("before transaction");
		T object = currentSession.get(genericType, theId);
		System.out.println(object);
		return object;
	}

	@Override
	public void saveObj(T obj) {
		// get current session
		Session currentSession = entityManager.unwrap(Session.class);

		// save/upate the customer ... finally LOL
		System.out.println("save or update: " + obj);
		currentSession.saveOrUpdate(obj);
	}

	@Override
	public void deleteById(int theId) {
		// get current session
		Session currentSession = entityManager.unwrap(Session.class);

		// delete object with primary key
		String hql = String.format("delete from %s where id=%d", genericType.getName(), theId);

		Query theQuery = currentSession.createQuery(hql);
		
//		theQuery.setParameter("theId", theId);

		theQuery.executeUpdate();
	}

}
