package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.validator.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "numero")
public class FuncionarioSecretario extends Funcionario {

	@NotNull
	private String grauEscolaridade;

	public FuncionarioSecretario() {

	}

	public FuncionarioSecretario(String nome, String sexo, Date dataAniversario, Double salario, Endereco endereco,
			Departamento departamento, String grauEscolaridade) {
		super(nome, sexo, dataAniversario, salario, endereco, departamento);
		this.grauEscolaridade = grauEscolaridade;
	}

	public String getGrauEscolaridade() {
		return grauEscolaridade;
	}

	public void setGrauEscolaridade(String grauEscolaridade) {
		this.grauEscolaridade = grauEscolaridade;
	}

	@Override
	public String toString() {
		return super.toString() + " > FuncionarioSecretario [grauEscolaridade=" + grauEscolaridade + "]";
	}

}
