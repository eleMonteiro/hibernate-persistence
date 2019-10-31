package dao;

import java.util.List;

import models.Projeto;

public interface ProjetoDAO extends GenericoDAO<Projeto> {

	public List<Projeto> findByDepartamento(Integer numeroDepartamento);

}
