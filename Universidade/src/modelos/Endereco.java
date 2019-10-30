package modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private String rua;

	@NotEmpty
	private Integer numero;

	@NotNull
	private String cidade;

//	@ManyToMany
//	@JoinTable(name = "funcionario_endereco", joinColumns = @JoinColumn(name = "endereco_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "funcionario_id", referencedColumnName = "numeroFuncionario"))
//	private List<Funcionario> funcionarios;
	
	@ManyToOne
	@JoinColumn(name = "numeroFuncionario")
	private Funcionario funcionario_endereco;

	public Endereco() {

	}

	public Endereco(String rua, Integer numero, String cidade) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Endereco { Rua: " + rua + ", Numero: " + numero + ", Cidade: " + cidade + " }";
	}

}