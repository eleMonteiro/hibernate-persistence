package controller;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import dao.DepartamentoDAO;
import dao.FuncionarioDAO;
import dao.FuncionarioLimpezaDAO;
import dao.FuncionarioPesquisadorDAO;
import dao.FuncionarioSecretarioDAO;
import dao.jpa.DepartamentoJPADAO;
import dao.jpa.FuncionarioJPADAO;
import dao.jpa.FuncionarioLimpezaJPADAO;
import dao.jpa.FuncionarioPesquisadorJPADAO;
import dao.jpa.FuncionarioSecretarioJPADAO;
import models.Departamento;
import models.Endereco;
import models.Funcionario;
import models.FuncionarioLimpeza;
import models.FuncionarioPesquisador;
import models.FuncionarioSecretario;

public class FuncionarioController {

	public void adicionarPesquisador(String nome, String sexo, Date dataAniversario, Double salario, String rua,
			Integer numero, String cidade, Integer numeroDepartamento, String areaAtuacao) {
		FuncionarioPesquisadorDAO pesquisadorDAO = new FuncionarioPesquisadorJPADAO();
		DepartamentoDAO departamentoDAO = new DepartamentoJPADAO();

		try {
			Endereco endereco = new Endereco(rua, numero, cidade);
			Departamento departamento = departamentoDAO.find(numeroDepartamento);

			if (departamento != null) {
				FuncionarioPesquisador pesquisador = new FuncionarioPesquisador(numeroDepartamento, nome, sexo,
						dataAniversario, salario, endereco, departamento, areaAtuacao);

				pesquisadorDAO.beginTransaction();
				pesquisadorDAO.save(pesquisador);
				pesquisadorDAO.commit();
			}
		} catch (IllegalStateException | PersistenceException e) {
			pesquisadorDAO.rollback();
			e.printStackTrace();
		} finally {
			try {
				pesquisadorDAO.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void adicionarSecretario(String nome, String sexo, Date dataAniversario, Double salario, String rua,
			Integer numero, String cidade, Integer numeroDepartamento, String grauEscolaridade) {
		FuncionarioSecretarioDAO secretarioDAO = new FuncionarioSecretarioJPADAO();
		DepartamentoDAO departamentoDAO = new DepartamentoJPADAO();

		try {
			Endereco endereco = new Endereco(rua, numero, cidade);
			Departamento departamento = departamentoDAO.find(numeroDepartamento);

			if (departamento != null) {
				FuncionarioSecretario secretario = new FuncionarioSecretario(nome, sexo, dataAniversario, salario,
						endereco, departamento, grauEscolaridade);

				secretarioDAO.beginTransaction();
				secretarioDAO.save(secretario);
				secretarioDAO.commit();
			}
		} catch (IllegalStateException | PersistenceException e) {
			secretarioDAO.rollback();
			e.printStackTrace();
		} finally {
			try {
				secretarioDAO.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void adicionarFuncionarioLimpeza(String nome, String sexo, Date dataAniversario, Double salario, String rua,
			Integer numero, String cidade, Integer numeroDepartamento, Integer jornadaTrabalho, String cargo,
			Integer numeroGerente) {
		FuncionarioLimpezaDAO funcionarioLimpezaDAO = new FuncionarioLimpezaJPADAO();
		DepartamentoDAO departamentoDAO = new DepartamentoJPADAO();

		try {
			Endereco endereco = new Endereco(rua, numero, cidade);
			Departamento departamento = departamentoDAO.find(numeroDepartamento);
			FuncionarioLimpeza gerente = funcionarioLimpezaDAO.find(numeroGerente);

			if (departamento != null && gerente != null) {
				FuncionarioLimpeza funcionarioLimpeza = new FuncionarioLimpeza(nome, sexo, dataAniversario, salario,
						endereco, departamento, jornadaTrabalho, cargo, gerente);

				funcionarioLimpezaDAO.beginTransaction();
				funcionarioLimpezaDAO.save(funcionarioLimpeza);
				funcionarioLimpezaDAO.commit();
			}
		} catch (IllegalStateException | PersistenceException e) {
			funcionarioLimpezaDAO.rollback();
			e.printStackTrace();
		} finally {
			try {
				funcionarioLimpezaDAO.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void removerFuncionario(Integer numero) {
		FuncionarioDAO funcionarioDAO = new FuncionarioJPADAO();

		try {
			funcionarioDAO.beginTransaction();
			funcionarioDAO.delete(funcionarioDAO.find(numero));
			funcionarioDAO.commit();
		} catch (IllegalStateException | PersistenceException e) {
			funcionarioDAO.rollback();
			e.printStackTrace();
		} finally {
			try {
				funcionarioDAO.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Funcionario> buscarTodosOsFuncionarios() {
		FuncionarioDAO funcionarioDAO = new FuncionarioJPADAO();

		return funcionarioDAO.findAll();
	}

	public Funcionario buscarFuncionarioPorNumero(Integer numero) {
		FuncionarioDAO funcionarioDAO = new FuncionarioJPADAO();

		return funcionarioDAO.find(numero);
	}

}
