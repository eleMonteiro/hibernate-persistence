package modelos;

import java.util.Date;

import javax.persistence.Entity;

import org.hibernate.validator.NotNull;

@Entity
public class Secretario extends Funcionario {

	@NotNull
	private String grauEscolaridade;

	public Secretario() {

	}

	public Secretario(String nome, String sexo, Date data_aniversario, Double salario, String grau_escolaridade) {
		super(nome, sexo, data_aniversario, salario);
		this.grauEscolaridade = grau_escolaridade;
	}

	public String getGrauEscolaridade() {
		return grauEscolaridade;
	}

	public void setGrauEscolaridade(String grauEscolaridade) {
		this.grauEscolaridade = grauEscolaridade;
	}

}
