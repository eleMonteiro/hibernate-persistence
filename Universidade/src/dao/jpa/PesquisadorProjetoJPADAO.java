package dao.jpa;

import dao.PesquisadorProjetoDAO;
import models.PesquisadorProjeto;

public class PesquisadorProjetoJPADAO extends GenericoJPADAO<PesquisadorProjeto> implements PesquisadorProjetoDAO {

	public PesquisadorProjetoJPADAO() {
		super(PesquisadorProjeto.class);
	}

}
