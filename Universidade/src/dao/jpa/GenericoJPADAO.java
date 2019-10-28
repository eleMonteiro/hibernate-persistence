package dao.jpa;

import java.util.List;

import dao.GenericoDAO;
import jpa.JPAUtil;

public class GenericoJPADAO<T> implements GenericoDAO<T>{

	private Class<T> persistenceClass;
	
	public GenericoJPADAO(Class<T> persistenceClass) {
		this.persistenceClass = persistenceClass;
	}

	@Override
	public void save(T entity) {
		JPAUtil.getEntityManager().merge(entity);
	}

	@Override
	public void delete(T entity) {
	}

	@Override
	public void deleteById(Integer id) {
	}
	
	@Override
	public T find(Object id) {
		return null;
	}

	@Override
	public List<T> findAll() {
		return null;
	}

	@Override
	public void beginTransaction() {
		JPAUtil.beginTransaction();
	}

	@Override
	public void commit() {
		JPAUtil.commit();
	}

	@Override
	public void rollback() {
		JPAUtil.rollback();
	}

	@Override
	public void close() {
		JPAUtil.closeEntityManager();
	}
	
}