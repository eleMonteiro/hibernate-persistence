package controller;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.ProjetoDAO;
import dao.jpa.ProjetoJPADAO;
import modelos.Departamento;
import modelos.Projeto;

public class ProjetoController {

	public void adicionarProjeto(String nome, Integer tempo, Integer numeroDepartamento) {
		ProjetoDAO projetoDAO = new ProjetoJPADAO();

		Departamento departamento = new DepartamentoController().buscarDepartamentoPorNumero(numeroDepartamento);

		try {
			projetoDAO.beginTransaction();

			projetoDAO.save(new Projeto(nome, tempo, departamento));

			projetoDAO.commit();
		} catch (IllegalStateException | PersistenceException e) {
			projetoDAO.rollback();

			e.printStackTrace();
		} finally {
			try {
				projetoDAO.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void removerProjeto(Integer numero) {
		ProjetoDAO projetoDAO = new ProjetoJPADAO();

		try {
			projetoDAO.beginTransaction();

			projetoDAO.delete(projetoDAO.find(numero));

			projetoDAO.commit();
		} catch (IllegalStateException | PersistenceException e) {
			projetoDAO.rollback();

			e.printStackTrace();
		} finally {
			try {
				projetoDAO.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Projeto> buscarTodosOsProjetos() {
		ProjetoDAO projetoDAO = new ProjetoJPADAO();

		return projetoDAO.findAll();
	}

	public Projeto buscarProjetoPorNumero(Integer numero) {
		ProjetoDAO projetoDAO = new ProjetoJPADAO();

		return projetoDAO.find(numero);
	}

}
