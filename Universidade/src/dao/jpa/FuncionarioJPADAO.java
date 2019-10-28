package dao.jpa;

import dao.FuncionarioDAO;
import modelos.Funcionario;

public class FuncionarioJPADAO extends GenericoJPADAO<Funcionario> implements FuncionarioDAO {

	public FuncionarioJPADAO() {
		super(Funcionario.class);
	}

}
