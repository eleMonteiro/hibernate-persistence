package dao.jpa;

import dao.SecretarioDAO;
import modelos.Secretario;

public class SecretarioJPADAO extends GenericoJPADAO<Secretario> implements SecretarioDAO {

	public SecretarioJPADAO() {
		super(Secretario.class);
	}
}
