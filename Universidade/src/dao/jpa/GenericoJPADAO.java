package dao.jpa;

import java.util.List;

import dao.GenericoDAO;

public class GenericoJPADAO<T> implements GenericoDAO<T>{

	private Class<T> persistenceClass;
	
	public GenericoJPADAO(Class<T> persistenceClass) {
		this.persistenceClass = persistenceClass;
	}
	
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T find(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void beginTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rollback() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
