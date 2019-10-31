package dao.jpa;

import dao.FuncionarioPesquisadorDAO;
import models.FuncionarioPesquisador;

public class FuncionarioPesquisadorJPADAO extends GenericoJPADAO<FuncionarioPesquisador>
		implements FuncionarioPesquisadorDAO {

	public FuncionarioPesquisadorJPADAO() {
		super(FuncionarioPesquisador.class);
	}
}
