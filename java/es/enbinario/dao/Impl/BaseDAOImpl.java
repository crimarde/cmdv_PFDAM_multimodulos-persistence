package es.enbinario.dao.Impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.enbinario.dao.BaseDAO;

@Repository
public abstract class BaseDAOImpl<T, K extends Serializable> implements BaseDAO<T, K> {

	private Class<T> myClass;

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.save(entity);
	}

	@Override
	public T create(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(entity);
		//session.flush();
		return entity;
	}

	@Override
	public T update(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
		//session.flush();
		return entity;
	}

	@Override
	public void delete(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);
		//session.flush();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public Session getSession(){
		Session sesion = sessionFactory.getCurrentSession();
		if( sesion == null){
			sesion = sessionFactory.openSession();
		}
		return sesion;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void setMyClass(final Class<T> classToSet){
		myClass = classToSet;
	}
	
	public Class<T> getMyClass() {
		return myClass;
	}
}
