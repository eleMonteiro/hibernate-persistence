package dao.jpa;

import dao.DepartamentoDAO;
import models.Departamento;

public class DepartamentoJPADAO extends GenericoJPADAO<Departamento> implements DepartamentoDAO {

	public DepartamentoJPADAO() {
		super(Departamento.class);
	}

}
