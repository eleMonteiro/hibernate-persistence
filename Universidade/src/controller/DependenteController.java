package controller;

import java.util.Date;

import javax.persistence.PersistenceException;

import dao.DependenteDAO;
import dao.FuncionarioDAO;
import dao.jpa.DependenteJPADAO;
import dao.jpa.FuncionarioJPADAO;
import models.Dependente;
import models.Funcionario;

public class DependenteController {

	public void adicionarDependente(Integer numeroFuncionario, String nome, String sexo, Date dataAniversario,
			String grauParentesco) {
		DependenteDAO dependenteDAO = new DependenteJPADAO();
		FuncionarioDAO funcionarioDAO = new FuncionarioJPADAO();

		try {
			Funcionario funcionario = funcionarioDAO.find(numeroFuncionario);

			if (funcionario != null) {
				Dependente dependente = new Dependente(nome, sexo, dataAniversario, grauParentesco, funcionario);

				dependenteDAO.beginTransaction();
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
