package controller;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.FuncionarioDAO;
import dao.ProjetoDAO;
import dao.TrabalhoDAO;
import dao.jpa.FuncionarioJPADAO;
import dao.jpa.ProjetoJPADAO;
import dao.jpa.TrabalhoJPADAO;
import modelos.Departamento;
import modelos.Pesquisador;
import modelos.Projeto;
import modelos.Trabalho;

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
	
	public void adicionarPesquisadorProjeto(Integer numero, Integer numeroPesquisador, Integer horas) {
		ProjetoDAO projetoDAO = new ProjetoJPADAO();
		FuncionarioDAO pesquisadorDAO = new FuncionarioJPADAO();
		TrabalhoDAO trabalhoDAO = new TrabalhoJPADAO();
		
		try {
			projetoDAO.beginTransaction();
			
			Projeto projeto = projetoDAO.find(numero);
			Pesquisador pesquisador = (Pesquisador) pesquisadorDAO.find(numeroPesquisador);
			
			Trabalho trabalho = new Trabalho(horas);
			trabalho.setProjeto(projeto);
			trabalho.setPesquisador(pesquisador);
			
			trabalhoDAO.save(trabalho);
			
			
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

	public List<Projeto> buscarProjetoPorDepartamento(Integer numero) {
		ProjetoDAO projetoDAO = new ProjetoJPADAO();

		return projetoDAO.findByDepartamento(numero);
	}

	

}
