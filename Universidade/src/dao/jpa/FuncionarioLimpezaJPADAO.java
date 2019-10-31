package dao.jpa;

import dao.FuncionarioLimpezaDAO;
import models.FuncionarioLimpeza;

public class FuncionarioLimpezaJPADAO extends GenericoJPADAO<FuncionarioLimpeza> implements FuncionarioLimpezaDAO {

	public FuncionarioLimpezaJPADAO() {
		super(FuncionarioLimpeza.class);
	}

}
