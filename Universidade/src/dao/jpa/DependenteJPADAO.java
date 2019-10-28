package dao.jpa;

import dao.DependenteDAO;
import modelos.Dependente;

public class DependenteJPADAO extends GenericoJPADAO<Dependente> implements DependenteDAO {

	public DependenteJPADAO() {
		super(Dependente.class);
	}
	
}
