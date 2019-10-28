package dao.jpa;

import dao.PesquisadorDAO;
import modelos.Pesquisador;

public class PesquisadorJPADAO extends GenericoJPADAO<Pesquisador> implements PesquisadorDAO {

	public PesquisadorJPADAO() {
		super(Pesquisador.class);
	}
}
