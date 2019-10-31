package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.validator.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "numero")
public class FuncionarioLimpeza extends Funcionario {

	@NotNull
	private Integer jornadaTrabalho;

	@NotNull
	private String cargo;

	@ManyToOne
	@JoinColumn
	private FuncionarioLimpeza gerente;

	@OneToMany(mappedBy = "gerente")
	private List<FuncionarioLimpeza> gerenciados;

	public FuncionarioLimpeza() {
		this.gerenciados = new ArrayList<>();
	}

	public FuncionarioLimpeza(String nome, String sexo, Date dataAniversario, Double salario, Endereco endereco,
			Departamento departamento, Integer jornadaTrabalho, String cargo, FuncionarioLimpeza gerente) {
		super(nome, sexo, dataAniversario, salario, endereco, departamento);
		this.jornadaTrabalho = jornadaTrabalho;
		this.cargo = cargo;
		this.gerente = gerente;
		this.gerenciados = new ArrayList<>();
	}

	public Integer getJornadaTrabalho() {
		return jornadaTrabalho;
	}

	public void setJornadaTrabalho(Integer jornadaTrabalho) {
		this.jornadaTrabalho = jornadaTrabalho;
	}

	@Override
	public String toString() {
		return super.toString() + " > FuncionarioLimpeza [jornadaTrabalho=" + jornadaTrabalho + ", cargo=" + cargo
				+ ", gerente=" + gerente + "]";
	}

}
