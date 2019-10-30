package controller;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import dao.FuncionarioDAO;
import dao.LimpezaDAO;
import dao.PesquisadorDAO;
import dao.SecretarioDAO;
import dao.jpa.FuncionarioJPADAO;
import dao.jpa.LimpezaJPADAO;
import dao.jpa.PesquisadorJPADAO;
import dao.jpa.SecretarioJPADAO;
import modelos.Departamento;
import modelos.Endereco;
import modelos.Funcionario;
import modelos.Limpeza;
import modelos.Pesquisador;
import modelos.Secretario;

public class FuncionarioController {

	public void adicionarPesquisador(String nome, String rua, Integer numeroCasa, String cidade, String sexo,
			Date dataAniversario, Double salario, String areaAtuacao, Integer departamento) {
		PesquisadorDAO pesquisadorDAO = new PesquisadorJPADAO();

		Endereco enderecoFuncionario = new Endereco(rua, numeroCasa, cidade);

		Pesquisador pesquisador = new Pesquisador(nome, sexo, dataAniversario, salario, areaAtuacao);
		pesquisador.setEndereco(enderecoFuncionario);
		pesquisador.setDepartamento(new Departamento(departamento));
		
		try {
			pesquisadorDAO.beginTransaction();
			pesquisadorDAO.save(pesquisador);
			pesquisadorDAO.commit();
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

	public void adicionarSecretario(String nome, String rua, Integer numeroCasa, String cidade, String sexo,
			Date dataAniversario, Double salario, String grauEscolaridade, Integer departamento) {
		SecretarioDAO secretarioDAO = new SecretarioJPADAO();

		Endereco enderecoFuncionario = new Endereco(rua, numeroCasa, cidade);

		Secretario secretario = new Secretario(nome, sexo, dataAniversario, salario, grauEscolaridade);
		secretario.setEndereco(enderecoFuncionario);
		secretario.setDepartamento(new Departamento(departamento));
		
		try {
			secretarioDAO.beginTransaction();
			secretarioDAO.save(secretario);
			secretarioDAO.commit();

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

	public void adicionarFuncionarioLimpeza(String nome, String rua, Integer numeroCasa, String cidade, String sexo,
			Date dataAniversario, Double salario, Integer jornadaTrabalho, Integer idGerente, String cargo, Integer departamento) {
		LimpezaDAO limpezaDAO = new LimpezaJPADAO();

		Endereco enderecoFuncionario = new Endereco(rua, numeroCasa, cidade);

		Limpeza limpeza = new Limpeza(nome, sexo, dataAniversario, salario, jornadaTrabalho, cargo);
		limpeza.setEndereco(enderecoFuncionario);
		limpeza.setDepartamento(new Departamento(departamento));
		try {
			limpezaDAO.beginTransaction();
			limpezaDAO.save(limpeza);
			limpezaDAO.commit();
		} catch (IllegalStateException | PersistenceException e) {
			limpezaDAO.rollback();
			
			e.printStackTrace();
		} finally {
			try {
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
