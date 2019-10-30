package dao;

import java.util.List;

import modelos.Projeto;

public interface ProjetoDAO extends GenericoDAO<Projeto> {

	public List<Projeto> findByDepartamento(Integer numeroDepartamento);
	
}
