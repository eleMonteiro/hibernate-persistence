package dao;

import java.util.List;

public interface GenericoDAO<T> {

	public void save(T entity);

	public void delete(T entity);

	public void deleteById(Integer id);

	public T find(Object id);

	public List<T> findAll();

	public void beginTransaction();

	public void commit();

	public void rollback();

	public void close();

}
