package dao.jpa;

import dao.TrabalhoDAO;
import modelos.Trabalho;

public class TrabalhoJPADAO extends GenericoJPADAO<Trabalho> implements TrabalhoDAO {

	public TrabalhoJPADAO() {
		super(Trabalho.class);
	}
	
}
