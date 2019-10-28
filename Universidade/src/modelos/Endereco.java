package modelos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "endId")
	private Integer id;
	
	@NotNull
	@Column(name = "endRua")
	private String rua;
	
	@NotEmpty
	@Column(name = "endNumero")
	private Integer numero;
	
	@NotNull
	@Column(name = "endCidade")
	private String cidade;
	
	@ManyToMany
	@JoinTable(
			name = "funcionario_endereco",
			joinColumns = 
				@JoinColumn(name = "endereco_id",
				referencedColumnName = "endnumero"),
			inverseJoinColumns = 
				@JoinColumn(
						name = "funcionario_id",
						referencedColumnName = "fnumero")
			)
	private List<Funcionario> funcionarios;
	
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
