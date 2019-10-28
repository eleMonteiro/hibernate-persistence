package modelos;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.NotNull;

@Entity
@AttributeOverride(name = "numero", column = @Column(name = "funcionario_id"))
public class Secretario extends Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "snumero")
	private Integer numero;

	@NotNull
	@Column(name = "grauescolaridade")
	private String grau_escolaridade;

	public Secretario() {

	}

	public Secretario(String nome, String sexo, Date data_aniversario, Double salario, String grau_escolaridade) {
		super(nome, sexo, data_aniversario, salario);
		this.grau_escolaridade = grau_escolaridade;
	}

	public String getGrauEscolaridade() {
		return grau_escolaridade;
	}

	public void setGrauEscolaridade(String grau_escolaridade) {
		this.grau_escolaridade = grau_escolaridade;
	}

}
