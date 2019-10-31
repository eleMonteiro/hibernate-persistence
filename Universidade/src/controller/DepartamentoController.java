package controller;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.DepartamentoDAO;
import dao.jpa.DepartamentoJPADAO;
import models.Departamento;

public class DepartamentoController {

	public void adicionarDepartamento(String nome) {
		DepartamentoDAO departamentoDAO = new DepartamentoJPADAO();

		try {
			departamentoDAO.beginTransaction();

			departamentoDAO.save(new Departamento(nome));

			departamentoDAO.commit();
		} catch (IllegalStateException | PersistenceException e) {
			departamentoDAO.rollback();

			e.printStackTrace();
		} finally {
			try {
				departamentoDAO.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void removerDepartamento(Integer numero) {
		DepartamentoDAO departamentoDAO = new DepartamentoJPADAO();

		try {
			departamentoDAO.beginTransaction();

			departamentoDAO.delete(departamentoDAO.find(numero));

			departamentoDAO.commit();
		} catch (IllegalStateException | PersistenceException e) {
			departamentoDAO.rollback();

			e.printStackTrace();
		} finally {
			try {
				departamentoDAO.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Departamento> buscarTodosOsDepartamentos() {
		DepartamentoDAO departamentoDAO = new DepartamentoJPADAO();

		return departamentoDAO.findAll();
	}

	public Departamento buscarDepartamentoPorNumero(Integer numero) {
		DepartamentoDAO departamentoDAO = new DepartamentoJPADAO();

		return departamentoDAO.find(numero);
	}

}
