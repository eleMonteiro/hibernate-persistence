package dao.jpa;

import dao.LimpezaDAO;
import modelos.Limpeza;

public class LimpezaJPADAO extends GenericoJPADAO<Limpeza> implements LimpezaDAO{

	public LimpezaJPADAO() {
		super(Limpeza.class);
	}
	
}
