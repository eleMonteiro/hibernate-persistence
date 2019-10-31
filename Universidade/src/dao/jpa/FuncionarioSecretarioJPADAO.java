package dao.jpa;

import dao.FuncionarioSecretarioDAO;
import models.FuncionarioSecretario;

public class FuncionarioSecretarioJPADAO extends GenericoJPADAO<FuncionarioSecretario>
		implements FuncionarioSecretarioDAO {

	public FuncionarioSecretarioJPADAO() {
		super(FuncionarioSecretario.class);
	}
}
