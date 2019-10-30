package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ProjetoDAO;
import jpa.JPAUtil;
import modelos.Projeto;

public class ProjetoJPADAO extends GenericoJPADAO<Projeto> implements ProjetoDAO {

	public ProjetoJPADAO() {
		super(Projeto.class);
	}

	@SuppressWarnings("unchecked")
	public List<Projeto> findByDepartamento(Integer numeroDepartamento) {

			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("SELECT c FROM Projeto c "
									   + "WHERE c.departamento.numero = :numero");
			query.setParameter("numero", numeroDepartamento);
			
			return query.getResultList();
		
	}
	
}
