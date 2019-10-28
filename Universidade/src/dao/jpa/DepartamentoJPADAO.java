package dao.jpa;

import dao.DepartamentoDAO;
import modelos.Departamento;

public class DepartamentoJPADAO extends GenericoJPADAO<Departamento> implements DepartamentoDAO{

	public DepartamentoJPADAO() {
		super(Departamento.class);
	}

}
