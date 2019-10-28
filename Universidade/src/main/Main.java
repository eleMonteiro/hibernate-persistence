package main;

import dao.DepartamentoDAO;
import dao.jpa.DepartamentoJPADAO;
import modelos.Departamento;

public class Main {

	public static void main(String[] args) {
		insertDepartamento();
	}

	private static void insertDepartamento() {
		DepartamentoDAO dDAO = new DepartamentoJPADAO();

		try {
			dDAO.beginTransaction();

			dDAO.save(new Departamento("Finanças"));

			dDAO.commit();
		} catch (Exception e) {
			dDAO.rollback();
			System.out.println(e.getMessage());
		} finally {
			try {
				dDAO.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
