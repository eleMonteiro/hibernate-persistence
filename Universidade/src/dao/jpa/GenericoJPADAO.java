package dao.jpa;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import dao.GenericoDAO;
import jpa.JPAUtil;

public class GenericoJPADAO<T> implements GenericoDAO<T> {

	private Class<T> persistenceClass;

	public GenericoJPADAO(Class<T> persistenceClass) {
		this.persistenceClass = persistenceClass;
	}

	@Override
	public void save(T t) {
		JPAUtil.getEntityManager().merge(t);
	}

	@Override
	public void delete(T t) {
		JPAUtil.getEntityManager().remove(JPAUtil.getEntityManager().merge(t));
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
	}

	@Override
	public T find(Object id) {
		return JPAUtil.getEntityManager().find(persistenceClass, id);
	}

	@Override
	public List<T> findAll() {
		CriteriaQuery<T> criteriaQuery = JPAUtil.getEntityManager().getCriteriaBuilder().createQuery(persistenceClass);
		criteriaQuery.from(persistenceClass);

		return JPAUtil.getEntityManager().createQuery(criteriaQuery).getResultList();
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