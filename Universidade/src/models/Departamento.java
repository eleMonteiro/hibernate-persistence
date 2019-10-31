package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.NotNull;

@Entity
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;

	@NotNull
	private String nome;

	@OneToMany(mappedBy = "departamento")
	private List<Funcionario> funcionarios;

	@OneToMany(mappedBy = "departamento")
	private List<Projeto> projetos;

	public Departamento() {
		this.funcionarios = new ArrayList<>();
		this.projetos = new ArrayList<>();
	}

	public Departamento(String nome) {
		super();
		this.nome = nome;
		this.funcionarios = new ArrayList<>();
		this.projetos = new ArrayList<>();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	@Override
	public String toString() {
		return "Departamento [numero=" + numero + ", nome=" + nome + "]";
	}

}
