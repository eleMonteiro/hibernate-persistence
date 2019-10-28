package dao.jpa;

import dao.EnderecoDAO;
import modelos.Endereco;

public class EnderecoJPADAO extends GenericoJPADAO<Endereco> implements EnderecoDAO {

	public EnderecoJPADAO() {
		super(Endereco.class);
	}

}
