package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dao.ProjetoDAO;
import models.Projeto;
import util.JPAUtil;

public class ProjetoJPADAO extends GenericoJPADAO<Projeto> implements ProjetoDAO {

	public ProjetoJPADAO() {
		super(Projeto.class);
	}

	public List<Projeto> findByDepartamento(Integer numeroDepartamento) {
		EntityManager em = JPAUtil.getEntityManager();

		TypedQuery<Projeto> query = em.createNamedQuery("Projeto.findByDepartamento", Projeto.class);
		query.setParameter("numero", numeroDepartamento);

		return query.getResultList();
	}

}
