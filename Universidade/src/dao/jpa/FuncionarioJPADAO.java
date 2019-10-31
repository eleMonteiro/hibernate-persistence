package dao.jpa;

import dao.FuncionarioDAO;
import models.Funcionario;

public class FuncionarioJPADAO extends GenericoJPADAO<Funcionario> implements FuncionarioDAO {

	public FuncionarioJPADAO() {
		super(Funcionario.class);
	}

}
