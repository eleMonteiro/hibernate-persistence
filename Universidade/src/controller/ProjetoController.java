package controller;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.DepartamentoDAO;
import dao.FuncionarioPesquisadorDAO;
import dao.PesquisadorProjetoDAO;
import dao.ProjetoDAO;
import dao.jpa.DepartamentoJPADAO;
import dao.jpa.FuncionarioPesquisadorJPADAO;
import dao.jpa.PesquisadorProjetoJPADAO;
import dao.jpa.ProjetoJPADAO;
import models.Departamento;
import models.FuncionarioPesquisador;
import models.PesquisadorProjeto;
import models.Projeto;

public class ProjetoController {

	public void adicionarProjeto(String nome, Integer tempo, Integer numeroDepartamento) {
		ProjetoDAO projetoDAO = new ProjetoJPADAO();
		DepartamentoDAO departamentoDAO = new DepartamentoJPADAO();

		try {
			Departamento departamento = departamentoDAO.find(numeroDepartamento);

			if (departamento != null) {
				Projeto projeto = new Projeto(nome, tempo, departamento);

				projetoDAO.beginTransaction();
				projetoDAO.save(projeto);
				projetoDAO.commit();
			}
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

	public void adicionarPesquisadorProjeto(Integer numeroProjeto, Integer numeroPesquisador, Integer horasSemanais) {
		FuncionarioPesquisadorDAO pesquisadorDAO = new FuncionarioPesquisadorJPADAO();
		ProjetoDAO projetoDAO = new ProjetoJPADAO();
		PesquisadorProjetoDAO pesquisadorProjetoDAO = new PesquisadorProjetoJPADAO();

		try {
			FuncionarioPesquisador pesquisador = pesquisadorDAO.find(numeroPesquisador);
			Projeto projeto = projetoDAO.find(numeroProjeto);

			if (pesquisador != null && projeto != null) {
				PesquisadorProjeto pesquisadorProjeto = new PesquisadorProjeto(pesquisador, projeto, horasSemanais);

				pesquisadorProjetoDAO.beginTransaction();
				pesquisadorProjetoDAO.save(pesquisadorProjeto);
				pesquisadorProjetoDAO.commit();
			}
		} catch (IllegalStateException | PersistenceException e) {
			pesquisadorProjetoDAO.rollback();

			e.printStackTrace();
		} finally {
			try {
				pesquisadorProjetoDAO.close();
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

	public List<Projeto> buscarProjetoPorDepartamento(Integer numero) {
		ProjetoDAO projetoDAO = new ProjetoJPADAO();

		return projetoDAO.findByDepartamento(numero);
	}

}
