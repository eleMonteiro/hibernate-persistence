package dao.jpa;

import dao.EnderecoDAO;
import models.Endereco;

public class EnderecoJPADAO extends GenericoJPADAO<Endereco> implements EnderecoDAO {

	public EnderecoJPADAO() {
		super(Endereco.class);
	}

}
