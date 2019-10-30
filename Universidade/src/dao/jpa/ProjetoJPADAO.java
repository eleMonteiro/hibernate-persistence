package dao.jpa;

import dao.ProjetoDAO;
import modelos.Projeto;

public class ProjetoJPADAO extends GenericoJPADAO<Projeto> implements ProjetoDAO {

	public ProjetoJPADAO() {
		super(Projeto.class);
	}
	
}
