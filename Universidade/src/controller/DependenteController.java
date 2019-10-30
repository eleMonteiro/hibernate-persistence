package controller;

import java.util.Date;

import javax.persistence.PersistenceException;

import dao.DependenteDAO;
import dao.FuncionarioDAO;
import dao.jpa.DependenteJPADAO;
import dao.jpa.FuncionarioJPADAO;
import modelos.Dependente;
import modelos.Funcionario;

public class DependenteController {

	public void adicionarDependente(Integer numeroFuncDependente, String nomeDependente, String sexo,
			Date dataAniversarioDependente, String grauparentesco) {

		DependenteDAO dependenteDAO = new DependenteJPADAO();
		FuncionarioDAO funcionarioDAO = new FuncionarioJPADAO();

		try {
			Funcionario funcionario = funcionarioDAO.find(numeroFuncDependente);
			if( funcionario != null) {
				dependenteDAO.beginTransaction();
				Dependente dependente = new Dependente(nomeDependente, sexo, dataAniversarioDependente, grauparentesco);
				dependente.setFuncionario(funcionario);
				
				dependenteDAO.save(dependente);
				dependenteDAO.commit();
			}
		} catch (IllegalStateException | PersistenceException e) {
			dependenteDAO.rollback();

			e.printStackTrace();
		} finally {
			try {
				dependenteDAO.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
