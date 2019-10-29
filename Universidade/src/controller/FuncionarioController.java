package controller;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import dao.EnderecoDAO;
import dao.FuncionarioDAO;
import dao.LimpezaDAO;
import dao.PesquisadorDAO;
import dao.SecretarioDAO;
import dao.jpa.EnderecoJPADAO;
import dao.jpa.FuncionarioJPADAO;
import dao.jpa.LimpezaJPADAO;
import dao.jpa.PesquisadorJPADAO;
import dao.jpa.SecretarioJPADAO;
import modelos.Endereco;
import modelos.Funcionario;
import modelos.Limpeza;
import modelos.Pesquisador;
import modelos.Secretario;

public class FuncionarioController {

	public void adicionarPesquisador(String nome, String rua, Integer numeroCasa, String cidade, String sexo,
			Date dataAniversario, Double salario, String areaAtuacao) {
		EnderecoDAO enderecoDAO = new EnderecoJPADAO();
		PesquisadorDAO pesquisadorDAO = new PesquisadorJPADAO();

		Endereco enderecoFuncionario = new Endereco(rua, numeroCasa, cidade);

		Pesquisador pesquisador = new Pesquisador(nome, sexo, dataAniversario, salario, areaAtuacao);
		pesquisador.addEndereco(enderecoFuncionario);

		try {
			enderecoDAO.beginTransaction();
			enderecoDAO.save(enderecoFuncionario);
			enderecoDAO.commit();

			pesquisadorDAO.beginTransaction();
			pesquisadorDAO.save(pesquisador);
			pesquisadorDAO.commit();
		} catch (IllegalStateException | PersistenceException e) {
			enderecoDAO.rollback();
			pesquisadorDAO.rollback();

			e.printStackTrace();
		} finally {
			try {
				enderecoDAO.close();
				pesquisadorDAO.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void adicionarSecretario(String nome, String rua, Integer numeroCasa, String cidade, String sexo,
			Date dataAniversario, Double salario, String grauEscolaridade) {
		EnderecoDAO enderecoDAO = new EnderecoJPADAO();
		SecretarioDAO secretarioDAO = new SecretarioJPADAO();

		Endereco enderecoFuncionario = new Endereco(rua, numeroCasa, cidade);

		Secretario secretario = new Secretario(nome, sexo, dataAniversario, salario, grauEscolaridade);
		secretario.addEndereco(enderecoFuncionario);

		try {
			enderecoDAO.beginTransaction();
			enderecoDAO.save(enderecoFuncionario);
			enderecoDAO.commit();

			secretarioDAO.beginTransaction();
			secretarioDAO.save(secretario);
			secretarioDAO.commit();
		} catch (IllegalStateException | PersistenceException e) {
			enderecoDAO.rollback();
			secretarioDAO.rollback();

			e.printStackTrace();
		} finally {
			try {
				enderecoDAO.close();
				secretarioDAO.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void adicionarFuncionarioLimpeza(String nome, String rua, Integer numeroCasa, String cidade, String sexo,
			Date dataAniversario, Double salario, Integer jornadaTrabalho, Integer idGerente) {
		EnderecoDAO enderecoDAO = new EnderecoJPADAO();
		LimpezaDAO limpezaDAO = new LimpezaJPADAO();

		Endereco enderecoFuncionario = new Endereco(rua, numeroCasa, cidade);

		Limpeza limpeza = new Limpeza(nome, sexo, dataAniversario, salario, jornadaTrabalho);
		limpeza.addEndereco(enderecoFuncionario);

		try {
			enderecoDAO.beginTransaction();
			enderecoDAO.save(enderecoFuncionario);
			enderecoDAO.commit();

			limpezaDAO.beginTransaction();
			limpezaDAO.save(limpeza);
			limpezaDAO.commit();
		} catch (IllegalStateException | PersistenceException e) {
			enderecoDAO.rollback();
			limpezaDAO.rollback();

			e.printStackTrace();
		} finally {
			try {
				enderecoDAO.close();
				limpezaDAO.close();
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
